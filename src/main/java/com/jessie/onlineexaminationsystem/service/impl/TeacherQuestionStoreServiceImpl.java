package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.StoreQuestionVO;
import com.jessie.onlineexaminationsystem.domain.TeacherQuestionStore;
import com.jessie.onlineexaminationsystem.mapper.TeacherQuestionStoreMapper;
import com.jessie.onlineexaminationsystem.service.TeacherQuestionStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【teacher_question_store(题库)】的数据库操作Service实现
 * @createDate 2022-03-20 01:26:51
 */
@Service
public class TeacherQuestionStoreServiceImpl extends ServiceImpl<TeacherQuestionStoreMapper, TeacherQuestionStore>
        implements TeacherQuestionStoreService {

    @Autowired
    TeacherQuestionStoreMapper teacherQuestionStoreMapper;


    @Override
    public void newQuestionStore(TeacherQuestionStore teacherQuestionStore) {
        teacherQuestionStoreMapper.insertAll(teacherQuestionStore);
    }

    @Override
    public List<TeacherQuestionStore> getAllByTeacher(int teacherID) {
        return teacherQuestionStoreMapper.selectByTeacher(teacherID);
    }

    @Override
    @Transactional
    public StoreQuestionVO getAllQuestionByStore(Integer store) {
        TeacherQuestionStore teacherQuestionStore = teacherQuestionStoreMapper.selectOneById(store);
        StoreQuestionVO storeQuestionVO = new StoreQuestionVO();
        if ("selections".equals(teacherQuestionStore.getType())) {
            storeQuestionVO.setQuestions(teacherQuestionStoreMapper.selectSelectionsByStore(store));
        } else if ("blanks".equals(teacherQuestionStore.getType())) {
            storeQuestionVO.setQuestions(teacherQuestionStoreMapper.selectBlanksByStore(store));
        } else if ("answerQuestions".equals(teacherQuestionStore.getType())) {
            storeQuestionVO.setQuestions(teacherQuestionStoreMapper.selectAnswerQuestionsByStore(store));
        }
        return storeQuestionVO;
    }

}




