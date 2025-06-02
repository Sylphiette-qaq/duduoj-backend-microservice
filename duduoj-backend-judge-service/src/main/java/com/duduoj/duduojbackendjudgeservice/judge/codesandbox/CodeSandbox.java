package com.duduoj.duduojbackendjudgeservice.judge.codesandbox;

import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeResponse;

public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
