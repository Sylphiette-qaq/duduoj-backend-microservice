package com.duduoj.duduojbackendjudgeservice.judge.codesandbox.impl;



import com.duduoj.duduojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeRequest;
import com.duduoj.duduojbackendmodule.model.codeSandbox.ExecuteCodeResponse;
import com.duduoj.duduojbackendmodule.model.codeSandbox.JudgeInfo;

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
