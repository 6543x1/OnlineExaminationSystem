package com.jessie.onlineexaminationsystem.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.jessie.onlineexaminationsystem.domain.ExamStu;
import com.jessie.onlineexaminationsystem.domain.ExamWithPointsAndScore;
import com.jessie.onlineexaminationsystem.domain.Result;
import com.jessie.onlineexaminationsystem.service.ExamPaperService;
import com.jessie.onlineexaminationsystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    ExamService examService;
    @Autowired
    ExamPaperService examPaperService;

    @PostMapping("/getExam")
    public Result getMyExam() {

        return Result.success("");
    }

    @PostMapping("/getExamPaper")
    public Result getExamPaper(@RequestBody Integer examID) {

        return Result.success("成功", examPaperService.selectOneByID(examID));
    }

    @PostMapping("getExamByStuID")
    public Result getAllByStu() {
        Integer sid = StpUtil.getLoginId(0);
        List<ExamWithPointsAndScore> list = examService.getExamWithPointsByStuID(sid);
        return Result.success("成功", list);
    }

    @PostMapping("commitExamPaper")
    @SaCheckRole("student")
    public Result commitExamPaper(@RequestBody ExamStu examStu) {
        examStu.setUid(StpUtil.getLoginId(0));
        examPaperService.updateExamPaper(examStu);
        return Result.success("提交成功");
    }

}
