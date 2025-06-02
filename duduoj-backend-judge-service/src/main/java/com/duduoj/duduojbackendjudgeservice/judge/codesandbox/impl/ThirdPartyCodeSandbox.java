package com.duduoj.duduojbackendjudgeservice.judge.codesandbox.impl;


import com.duduoj.duduojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeRequest;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return new ExecuteCodeResponse();
    }

}
