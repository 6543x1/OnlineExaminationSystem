package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.BaseQuestion;
import com.jessie.onlineexaminationsystem.domain.TeacherQuestionStore;
import com.jessie.onlineexaminationsystem.domain.TeacherQuestionStoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【teacher_question_store(题库)】的数据库操作Mapper
 * @createDate 2022-03-20 01:26:51
 * @Entity com.jessie.onlineexaminationsystem.domain.TeacherQuestionStore
 */
public interface TeacherQuestionStoreMapper extends BaseMapper<TeacherQuestionStore> {

    int insertAll(TeacherQuestionStore teacherQuestionStore);

    TeacherQuestionStore selectOneById(@Param("id") Integer id);

    List<TeacherQuestionStore> selectByTeacher(@Param("teacher") Integer teacher);

    List<TeacherQuestionStoreVO> selectOneById2(@Param("id") Integer id);

    List<BaseQuestion> selectSelectionsByStore(@Param("store") Integer store);

    List<BaseQuestion> selectBlanksByStore(@Param("store") Integer store);

    List<BaseQuestion> selectAnswerQuestionsByStore(@Param("store") Integer store);

}




