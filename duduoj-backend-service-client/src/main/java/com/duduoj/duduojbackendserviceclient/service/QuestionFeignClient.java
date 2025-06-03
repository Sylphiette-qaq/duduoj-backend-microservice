package com.duduoj.duduojbackendserviceclient.service;


import com.duduoj.duduojbackendmodule.model.entity.Question;
import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author 86199
* @description 针对表【question(题目表)】的数据库操作Service
* @createDate 2025-05-23 00:25:21
*/
@FeignClient(name = "duduoj-backend-question-service", path = "/api/question/inner")
public interface QuestionFeignClient{


    @GetMapping("/get/id")
    Question getById(@RequestParam("questionId") long id);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    Boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);


}
