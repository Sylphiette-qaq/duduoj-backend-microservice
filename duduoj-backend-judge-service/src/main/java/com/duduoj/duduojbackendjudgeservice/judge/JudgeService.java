package com.duduoj.duduojbackendjudgeservice.judge;


import com.yupi.duduOj.model.entity.QuestionSubmit;

public interface JudgeService {

    /**
     * 执行判题
     *
     * @param QuestionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long QuestionSubmitId);
}
