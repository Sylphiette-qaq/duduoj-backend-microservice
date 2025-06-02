package com.duduoj.duduojbackendjudgeservice.judge.strategy;


import com.duduoj.duduojbackendmodule.model.codeSandbox.JudgeInfo;
import com.duduoj.duduojbackendmodule.model.dto.question.JudgeCase;
import com.duduoj.duduojbackendmodule.model.entity.Question;
import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 判题可能用到的参数
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private List<JudgeCase> judgeCaseList;

    private QuestionSubmit questionSubmit;
}
