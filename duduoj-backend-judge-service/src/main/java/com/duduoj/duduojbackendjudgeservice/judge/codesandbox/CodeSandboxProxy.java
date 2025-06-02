package com.duduoj.duduojbackendjudgeservice.judge.codesandbox;

import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱代理请求信息: " + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱代理响应信息: " + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
