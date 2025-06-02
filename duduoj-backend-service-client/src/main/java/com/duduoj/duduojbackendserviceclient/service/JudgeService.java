package com.duduoj.duduojbackendserviceclient.service;


import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;

public interface JudgeService {

    /**
     * 执行判题
     *
     * @param QuestionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long QuestionSubmitId);
}
