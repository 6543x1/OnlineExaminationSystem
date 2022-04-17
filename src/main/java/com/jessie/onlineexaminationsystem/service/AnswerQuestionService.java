package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestion;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestionVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【answer_question】的数据库操作Service
 * @createDate 2022-04-05 00:34:50
 */
public interface AnswerQuestionService extends IService<AnswerQuestion> {

    @Transactional
    void insertBatch(AnswerQuestionVO answerQuestionVO);

    List<AnswerQuestion> selectByTeacher(Integer teacher);

    List<AnswerQuestion> search(String key);
}
