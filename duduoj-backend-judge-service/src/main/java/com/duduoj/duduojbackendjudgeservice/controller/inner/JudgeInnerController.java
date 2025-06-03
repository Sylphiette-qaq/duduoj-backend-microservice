package com.duduoj.duduojbackendjudgeservice.controller.inner;

import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;
import com.duduoj.duduojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.duduoj.duduojbackendjudgeservice.judge.JudgeService;

import javax.annotation.Resource;


/**
 * 内部接口
 *
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;


    /**
     * 执行判题
     *
     * @param QuestionSubmitId
     * @return
     */
    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSumbitId") long QuestionSubmitId){
        return judgeService.doJudge(QuestionSubmitId);
    }
}
