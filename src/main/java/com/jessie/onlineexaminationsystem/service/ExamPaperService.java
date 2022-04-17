package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.ExamPaper;
import com.jessie.onlineexaminationsystem.domain.ExamStu;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam_paper】的数据库操作Service
 * @createDate 2022-03-20 01:26:42
 */
public interface ExamPaperService extends IService<ExamPaper> {

    void newExamPaper(ExamPaper examPaper);

    void editExamPaper(ExamPaper examPaper);

    List<ExamPaper> getExamPaperByTeacher(int teacher);

    ExamPaper selectOneByID(int id);

    void updateExamPaper(ExamStu examStu);

    List<ExamStu> getStuExamPaper(Integer examID);
}
