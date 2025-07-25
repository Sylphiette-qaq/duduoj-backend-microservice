package com.duduoj.duduojbackendmodule.model.codeSandbox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {

    private List<String> outputList;

    /**
     * 执行状态
     */
    private Integer status;

    /**
     * 接口消息
     */
    private String message;


    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;
}
