package com.duduoj.duduojbackendquestionservice.controller.inner;

import com.duduoj.duduojbackendmodule.model.entity.Question;
import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;
import com.duduoj.duduojbackendquestionservice.service.QuestionService;
import com.duduoj.duduojbackendquestionservice.service.QuestionSubmitService;
import com.duduoj.duduojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 内部接口
 *
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;


    @Override
    @GetMapping("/get/id")
    public Question getById(@RequestParam("questionId") long id){
        return questionService.getById(id);
    }

    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/question_submit/update")
    public Boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit){
        return questionSubmitService.updateById(questionSubmit);
    }
}
