package com.jessie.onlineexaminationsystem.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.*;
import com.jessie.onlineexaminationsystem.mapper.ExamMapper;
import com.jessie.onlineexaminationsystem.mapper.ExamStuMapper;
import com.jessie.onlineexaminationsystem.mapper.StudentMapper;
import com.jessie.onlineexaminationsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam】的数据库操作Service实现
 * @createDate 2022-04-09 00:26:47
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam>
        implements ExamService {

    @Autowired
    ExamMapper examMapper;
    @Autowired
    ExamStuMapper examStuMapper;
    @Autowired
    StudentMapper studentMapper;

    @Transactional
    @Override
    public void newExam(ExamVO examVo) {
        Exam exam = examVo.getExam();
        exam.setTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        exam.setPublishTime(LocalDateTime.now());
        examMapper.insertAll(examVo.getExam());
        examStuMapper.insertBatch(examVo.getStudents(), examVo.getExam().getId());
    }

    @Override
    public void addStudent(Integer examID, List<Integer> students) {
        examStuMapper.insertBatch(students, examID);
    }

    @Override
    public List<ExamWithScore> queryExam(Integer id) {
        System.out.println(examMapper.selectByTeacher(2));
        return examMapper.selectByTeacher(id);
    }

    @Override
    public List<Student> selectStudentInfo(Integer id) {
        return studentMapper.selectStuInfoByExamID(id);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<ExamWithScore> getExamByStuID(Integer id) {
        return examMapper.selectByStudentID(id);
    }

    @Override
    public int updateScore(PointsVO examWithPointsAndScore) {
        return examStuMapper.updatePoints(examWithPointsAndScore);
    }

    @Override
    public List<ExamWithPointsAndScore> getExamWithPointsByStuID(Integer id) {
        return examStuMapper.selectByUid(id);
    }

    @Override
    public List<ExamWithPointsAndScore> getExamWithPointsByExamID(Integer id) {
        return examStuMapper.selectByExamID(id);
    }

    @Override
    public List<StuPointsVO> getStuScoreInfo(Integer id) {
        return examStuMapper.selectByExamID2(id);
    }

    @Transactional
    @Override
    public Result getStuScoreInfoAndExam(Integer examID) {
        List<StuPointsVO> stuPointsVOS = examStuMapper.selectByExamID2(examID);
        ExamWithScore examWithScore = examMapper.selectByExamId(examID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("exam", examWithScore);
        jsonObject.put("detail", stuPointsVOS);
        return Result.success("成功", jsonObject);
    }
}




