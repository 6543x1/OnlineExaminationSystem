package com.jessie.onlineexaminationsystem.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.jessie.onlineexaminationsystem.domain.ExamPaper;
import com.jessie.onlineexaminationsystem.domain.ExamStu;
import com.jessie.onlineexaminationsystem.domain.Result;
import com.jessie.onlineexaminationsystem.service.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@SaCheckRole("teacher")
@RequestMapping("/examPaper")
public class ExamPaperController {

    @Autowired
    ExamPaperService examPaperService;


    @PostMapping("newExamPaper")
    public Result newExamPaper(@RequestBody ExamPaper examPaper) {
        examPaper.setUpdateTime(LocalDateTime.now());
        examPaper.setTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        examPaperService.newExamPaper(examPaper);
        return Result.success("新的试卷已经插入");
    }

    @PostMapping("editExamPaper")
    public Result editExamPaper(@RequestBody ExamPaper examPaper) {
        examPaper.setUpdateTime(LocalDateTime.now());
        examPaperService.editExamPaper(examPaper);
        return Result.success("试卷已经更新");
    }

    @PostMapping("getExamPaperByTeacher")
    public Result getExamPaperByTeacher(@RequestBody int teacher) {
        return Result.success("查询成功", examPaperService.getExamPaperByTeacher(teacher));
    }

    @PostMapping("getExamPaperByExamID")
    public Result getExamPaperByExamID(@RequestBody int examID) {
        return Result.success("查询成功", examPaperService.selectOneByID(examID));
    }

    @PostMapping("getStuExamPaper")
    public Result getStuExamPaper(@RequestBody Integer examID) {
        List<ExamStu> stuExamPaper = examPaperService.getStuExamPaper(examID);
        return Result.success("成功", stuExamPaper);
    }

    @PostMapping("editStuExamPaper")
    public Result getExamPaperByExamID(@RequestBody ExamStu examStu) {
        examPaperService.updateExamPaper(examStu);
        return Result.success("成功");
    }
}
