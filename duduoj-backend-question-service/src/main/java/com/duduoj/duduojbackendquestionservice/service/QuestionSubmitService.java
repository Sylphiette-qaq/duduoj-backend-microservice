package com.duduoj.duduojbackendquestionservice.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duduoj.duduojbackendmodule.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.duduoj.duduojbackendmodule.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.duduoj.duduojbackendmodule.model.entity.QuestionSubmit;
import com.duduoj.duduojbackendmodule.model.entity.User;
import com.duduoj.duduojbackendmodule.model.vo.QuestionSubmitVO;

/**
* @author 86199
* @description 针对表【question_submit( 题目提交 )】的数据库操作Service
* @createDate 2025-05-23 00:42:41
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
