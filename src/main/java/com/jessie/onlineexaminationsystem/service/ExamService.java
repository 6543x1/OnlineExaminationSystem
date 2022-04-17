package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam】的数据库操作Service
 * @createDate 2022-04-09 00:26:47
 */
public interface ExamService extends IService<Exam> {

    void newExam(ExamVO examVo);

    void addStudent(Integer examID, List<Integer> students);

    List<ExamWithScore> queryExam(Integer id);

    List<Student> selectStudentInfo(Integer id);

    List<Student> getAll();

    List<ExamWithScore> getExamByStuID(Integer id);

    int updateScore(PointsVO examWithPointsAndScore);

    List<ExamWithPointsAndScore> getExamWithPointsByStuID(Integer id);

    List<ExamWithPointsAndScore> getExamWithPointsByExamID(Integer id);

    List<StuPointsVO> getStuScoreInfo(Integer id);

    @Transactional
    Result getStuScoreInfoAndExam(Integer examID);
}
