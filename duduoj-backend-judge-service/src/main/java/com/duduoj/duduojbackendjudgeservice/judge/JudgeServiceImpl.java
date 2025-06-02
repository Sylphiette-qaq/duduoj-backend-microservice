package com.duduoj.duduojbackendjudgeservice.judge;

import cn.hutool.json.JSONUtil;
import com.duduoj.duduojbackendcommon.common.ErrorCode;
import com.duduoj.duduojbackendcommon.exception.BusinessException;
import com.duduoj.duduojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.duduoj.duduojbackendjudgeservice.judge.codesandbox.CodeSandboxFactory;
import com.duduoj.duduojbackendjudgeservice.judge.codesandbox.CodeSandboxProxy;
import com.duduoj.duduojbackendjudgeservice.judge.strategy.JudgeContext;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeRequest;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeResponse;
import com.duduoj.duduojbackendmodule.model.codeSandbox.JudgeInfo;
import com.duduoj.duduojbackendmodule.model.dto.question.JudgeCase;
import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;
import com.duduoj.duduojbackendmodule.model.enums.QuestionSubmitStatusEnum;
import com.duduoj.duduojbackendserviceclient.service.QuestionService;
import com.duduoj.duduojbackendserviceclient.service.QuestionSubmitService;
import com.duduoj.duduojbackendmodule.model.entity.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题服务实现类
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long QuestionSubmitId) {

        //1)    传入题目的提交id，获取到对应的题目、提交信息
        QuestionSubmit questionSubmit = questionSubmitService.getById(QuestionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交信息不存在");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }

        //2)    如果不为等待状态
        if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "题目正在提交");
        }

        //3)    修改题目状态为运行中,防止重复提交
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(QuestionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean update = questionSubmitService.updateById(questionSubmitUpdate);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "更新题目状态失败");
        }

        //4)    执行判题
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = questionSubmit.getCode();
        String language = questionSubmit.getLanguage();

        //5)    获取输入用例
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        // 执行代码
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();

        // 填充上下文信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setQuestion(question);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestionSubmit(questionSubmit);

        // 采用默认判题策略
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);

        // 修改数据库的判题结果
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(QuestionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionSubmitService.updateById(questionSubmitUpdate);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "更新题目状态失败");
        }
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(QuestionSubmitId);
        return questionSubmitResult;

    }
}
