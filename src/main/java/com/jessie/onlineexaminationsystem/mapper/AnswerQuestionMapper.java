package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【answer_question】的数据库操作Mapper
 * @createDate 2022-04-05 00:34:50
 * @Entity com.jessie.onlineexaminationsystem.domain.AnswerQuestion
 */
public interface AnswerQuestionMapper extends BaseMapper<AnswerQuestion> {
    int insertAll(AnswerQuestion answerQuestion);

    List<AnswerQuestion> selectByTeacher(@Param("teacher") Integer teacher);

    List<AnswerQuestion> searchAllByBody(@Param("body") String body);

    int insertBatch(@Param("answerQuestionCollection") Collection<AnswerQuestion> answerQuestionCollection);
}




