package com.duduoj.duduojbackendjudgeservice.judge.strategy;

import com.yupi.duduOj.judge.codesandbox.model.JudgeInfo;

/**
 * 默认判题策略
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);

}
