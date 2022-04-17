package com.jessie.onlineexaminationsystem.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.jessie.onlineexaminationsystem.domain.ExamVO;
import com.jessie.onlineexaminationsystem.domain.PointsVO;
import com.jessie.onlineexaminationsystem.domain.Result;
import com.jessie.onlineexaminationsystem.domain.Student;
import com.jessie.onlineexaminationsystem.service.ExamService;
import com.jessie.onlineexaminationsystem.service.ExamStuService;
import com.jessie.onlineexaminationsystem.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/exam")
@Api(tags = "试卷相关")
public class ExamController {
    @Autowired
    ExamService examService;
    @Autowired
    StudentService studentService;
    @Autowired
    ExamStuService examStuService;

    /*
     * 缺少：批改试卷
     * 缺少：查询成绩
     * 缺少：自动批改
     * 缺少：下载试卷
     * */
    @PostMapping("/newExam")
    @SaCheckRole("teacher")
    public Result newExam(@RequestBody ExamVO examVO) {
        //这里可能需要创建teacherID
        examService.newExam(examVO);
        System.out.println(examVO);
        return Result.success("插入成功", examVO.getExam().getId());
    }

    @PostMapping("/addStudent")
    @SaCheckRole("teacher")
    public Result newExam(@RequestBody String list) {
        //这里可能需要创建teacherID
        JSONObject jsonObject = JSONObject.parseObject(list);
        Integer examID = jsonObject.getInteger("examID");
        List<Integer> students = jsonObject.getJSONArray("students").toJavaList(Integer.class);
        examService.addStudent(examID, students);
//        System.out.println(examVO);
        return Result.success("新增学生成功");
    }

    @PostMapping("/getExam")
    public Result getExamByCourseID() {
        return Result.success("查询成功", examService.queryExam(StpUtil.getLoginId(0)));
    }

    @PostMapping("/getExamStudents")
    public Result getExamByCourseID(@RequestBody Integer examID) {
        return Result.success("查询成功", examService.selectStudentInfo(examID));
    }


    @PostMapping("searchStudent")
    public Result searchStu(@RequestBody Student student) {
        List<Student> students = studentService.selectByStudent(student);
        return Result.success("成功", students);
    }

    @PostMapping("getAllStudent")
    public Result getAllStu() {
        List<Student> students = examService.getAll();
        return Result.success("成功", students);
    }

    @PostMapping("/setScore")
    public Result setStuScore(@RequestBody PointsVO examWithPointsAndScore) {
        examService.updateScore(examWithPointsAndScore);
        return Result.success("成功");
    }

    @PostMapping("/getStuScore")
    public Result getStuScore(@RequestBody Integer examID) {

        return examService.getStuScoreInfoAndExam(examID);
    }


}
