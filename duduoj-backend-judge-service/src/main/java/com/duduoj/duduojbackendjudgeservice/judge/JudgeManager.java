package com.duduoj.duduojbackendjudgeservice.judge;

import com.yupi.duduOj.judge.codesandbox.model.JudgeInfo;
import com.yupi.duduOj.judge.strategy.DefaultJudgeStrategy;
import com.yupi.duduOj.judge.strategy.JudgeContext;
import com.yupi.duduOj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        DefaultJudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        return judgeStrategy.doJudge(judgeContext);
    }
}
