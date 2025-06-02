package com.duduoj.duduojbackendjudgeservice.judge.strategy;

import com.yupi.duduOj.judge.codesandbox.model.JudgeInfo;
import com.yupi.duduOj.model.dto.question.JudgeCase;
import com.yupi.duduOj.model.entity.Question;
import com.yupi.duduOj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 判题可能用到的参数
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private List<JudgeCase> judgeCaseList;

    private QuestionSubmit questionSubmit;
}
