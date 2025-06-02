package com.duduoj.duduojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yupi.duduOj.common.ErrorCode;
import com.yupi.duduOj.exception.BusinessException;
import com.yupi.duduOj.judge.codesandbox.CodeSandbox;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.duduOj.judge.codesandbox.model.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * 远程调用代码沙箱
 */
public class RemoteCodeSandbox implements CodeSandbox {

    // 鉴权请求头和密钥
    private static final String AUTH_REQUSET_HEADER = "auth";
    private static final String AUTH_REQUSET_SECRET = "duduoj";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        HttpResponse responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUSET_HEADER,AUTH_REQUSET_SECRET)
                .body(json)
                .execute();
        if(StringUtils.isBlank(responseStr.body())){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"executeCode error,message = " + responseStr.body());
        }
        return JSONUtil.toBean(responseStr.body(), ExecuteCodeResponse.class);
    }

}
