package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestion;
import com.jessie.onlineexaminationsystem.domain.AnswerQuestionStore;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * @author JessieLin
 * @description 针对表【answer_question_store】的数据库操作Mapper
 * @createDate 2022-04-05 14:32:23
 * @Entity com.jessie.onlineexaminationsystem.domain.AnswerQuestionStore
 */
public interface AnswerQuestionStoreMapper extends BaseMapper<AnswerQuestionStore> {
    int insertBatch(@Param("answerQuestionStoreCollection") Collection<AnswerQuestion> answerQuestionStoreCollection, @Param("store") Integer store);
}




