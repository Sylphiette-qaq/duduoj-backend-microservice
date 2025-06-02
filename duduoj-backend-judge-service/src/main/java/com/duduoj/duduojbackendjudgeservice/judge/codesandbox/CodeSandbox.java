package com.duduoj.duduojbackendjudgeservice.judge.codesandbox;


import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeRequest;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeResponse;

public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
