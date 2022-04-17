package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.ExamStu;
import com.jessie.onlineexaminationsystem.domain.ExamWithPointsAndScore;
import com.jessie.onlineexaminationsystem.domain.PointsVO;
import com.jessie.onlineexaminationsystem.domain.StuPointsVO;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam_stu】的数据库操作Mapper
 * @createDate 2022-04-09 00:37:42
 * @Entity com.jessie.onlineexaminationsystem.domain.ExamStu
 */
public interface ExamStuMapper extends BaseMapper<ExamStu> {
    int insertBatch(@Param("examStuCollection") Collection<Integer> examStuCollection, @Param("examID") Integer examID);

    List<ExamWithPointsAndScore> selectByUid(@Param("uid") Integer uid);

    int updatePoints(PointsVO examWithPointsAndScore);

    int updateExamPaperByExamIDAndUid(ExamStu examStu);

    List<ExamStu> selectAllByExamID(@Param("examID") Integer examID);

    List<ExamWithPointsAndScore> selectByExamID(@Param("examID") Integer examID);

    List<StuPointsVO> selectByExamID2(@Param("examID") Integer examID);
}




