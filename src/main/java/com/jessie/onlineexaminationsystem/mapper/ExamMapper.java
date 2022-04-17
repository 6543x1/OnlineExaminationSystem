package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Exam;
import com.jessie.onlineexaminationsystem.domain.ExamWithScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam】的数据库操作Mapper
 * @createDate 2022-04-09 00:26:47
 * @Entity com.jessie.onlineexaminationsystem.domain.Exam
 */
public interface ExamMapper extends BaseMapper<Exam> {

    int insertAll(Exam exam);

    List<ExamWithScore> selectByTeacher(@Param("teacher") Integer teacher);

    List<ExamWithScore> selectByStudentID(@Param("sid") Integer sid);

    ExamWithScore selectByExamId(@Param("id") Integer examID);


}




