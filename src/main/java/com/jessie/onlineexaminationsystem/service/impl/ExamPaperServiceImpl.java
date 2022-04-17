package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.ExamPaper;
import com.jessie.onlineexaminationsystem.domain.ExamStu;
import com.jessie.onlineexaminationsystem.mapper.ExamPaperMapper;
import com.jessie.onlineexaminationsystem.mapper.ExamStuMapper;
import com.jessie.onlineexaminationsystem.service.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【exam_paper】的数据库操作Service实现
 * @createDate 2022-03-20 01:26:42
 */
@Service
public class ExamPaperServiceImpl extends ServiceImpl<ExamPaperMapper, ExamPaper>
        implements ExamPaperService {
    @Autowired
    ExamPaperMapper examPaperMapper;
    @Autowired
    ExamStuMapper examStuMapper;

    @Override
    public void newExamPaper(ExamPaper examPaper) {
        examPaperMapper.insertAll(examPaper);
    }

    @Override
    public void editExamPaper(ExamPaper examPaper) {
        examPaperMapper.updateBodyAndUpdateTimeById(examPaper.getBody(), examPaper.getUpdateTime(), examPaper.getId());
    }

    @Override
    public List<ExamPaper> getExamPaperByTeacher(int teacher) {
        return examPaperMapper.selectByTeacher(teacher);
    }

    @Override
    public ExamPaper selectOneByID(int id) {
        return examPaperMapper.selectOneById(id);
    }

    @Override
    public void updateExamPaper(ExamStu examStu) {
        examStuMapper.updateExamPaperByExamIDAndUid(examStu);
    }

    @Override
    public List<ExamStu> getStuExamPaper(Integer examID) {
        return examStuMapper.selectAllByExamID(examID);
    }
}




