package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestion;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestionVO;
import com.jessie.onlineexaminationsystem.mapper.AnswerQuestionMapper;
import com.jessie.onlineexaminationsystem.mapper.AnswerQuestionStoreMapper;
import com.jessie.onlineexaminationsystem.service.AnswerQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【answer_question】的数据库操作Service实现
 * @createDate 2022-04-05 00:34:50
 */
@Service
public class AnswerQuestionServiceImpl extends ServiceImpl<AnswerQuestionMapper, AnswerQuestion>
        implements AnswerQuestionService {
    @Autowired
    AnswerQuestionMapper answerQuestionMapper;
    @Autowired
    AnswerQuestionStoreMapper answerQuestionStoreMapper;

    @Override
    @Transactional
    public void insertBatch(AnswerQuestionVO answerQuestionVO) {
        answerQuestionMapper.insertBatch(answerQuestionVO.getAnswerQuestions());
        answerQuestionStoreMapper.insertBatch(answerQuestionVO.getAnswerQuestions(), answerQuestionVO.getStore());
    }

    @Override
    public List<AnswerQuestion> selectByTeacher(Integer teacher) {
        return answerQuestionMapper.selectByTeacher(teacher);
    }

    @Override
    public List<AnswerQuestion> search(String key) {
        return answerQuestionMapper.searchAllByBody(key);
    }

}




