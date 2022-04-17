package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.ExamPaper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam_paper】的数据库操作Mapper
 * @createDate 2022-03-20 01:26:42
 * @Entity com.jessie.onlineexaminationsystem.domain.ExamPaper
 */
public interface ExamPaperMapper extends BaseMapper<ExamPaper> {

    int insertAll(ExamPaper examPaper);

    List<ExamPaper> selectByTeacher(@Param("teacher") Integer teacher);

    int updateBodyAndUpdateTimeById(@Param("body") String body, @Param("updateTime") LocalDateTime updateTime, @Param("id") Integer id);

    ExamPaper selectOneById(@Param("id") Integer id);


}




