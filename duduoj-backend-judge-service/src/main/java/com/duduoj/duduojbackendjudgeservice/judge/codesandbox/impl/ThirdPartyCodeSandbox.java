package com.duduoj.duduojbackendjudgeservice.judge.codesandbox.impl;

import com.yupi.duduOj.judge.codesandbox.CodeSandbox;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return new ExecuteCodeResponse();
    }

}
