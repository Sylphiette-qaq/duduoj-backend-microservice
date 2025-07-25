package com.duduoj.duduojbackendmodule.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 *
 * @author yupi
 */
@Data
public class JudgeConfig {

    /**
     * 时间限制(ms)
     */

    private long timeLimit;

    /**
     * 内存限制(KB)
     */

    private long memoryLimit;

    /**
     * 堆栈限制(KB)
     */

    private long stackLimit;
}

