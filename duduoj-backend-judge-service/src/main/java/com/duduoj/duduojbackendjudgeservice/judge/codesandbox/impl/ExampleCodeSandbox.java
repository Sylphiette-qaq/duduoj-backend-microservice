package com.duduoj.duduojbackendjudgeservice.judge.codesandbox.impl;

import com.yupi.duduOj.judge.codesandbox.CodeSandbox;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.duduOj.judge.codesandbox.model.JudgeInfo;

import java.util.ArrayList;

/**
 * 实例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(new ArrayList<>());
        executeCodeResponse.setMessage("666");
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage("666");
        judgeInfo.setMemory(10);
        judgeInfo.setTime(111);

        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }

}
