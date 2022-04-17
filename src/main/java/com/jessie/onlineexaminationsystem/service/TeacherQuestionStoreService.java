package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.StoreQuestionVO;
import com.jessie.onlineexaminationsystem.domain.TeacherQuestionStore;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【teacher_question_store(题库)】的数据库操作Service
 * @createDate 2022-03-20 01:26:51
 */
public interface TeacherQuestionStoreService extends IService<TeacherQuestionStore> {

    void newQuestionStore(TeacherQuestionStore teacherQuestionStore);

    List<TeacherQuestionStore> getAllByTeacher(int teacherID);

    StoreQuestionVO getAllQuestionByStore(Integer store);
}
