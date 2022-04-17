package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.StudentTeacher;
import com.jessie.onlineexaminationsystem.mapper.StudentTeacherMapper;
import com.jessie.onlineexaminationsystem.service.StudentTeacherService;
import org.springframework.stereotype.Service;

/**
 * @author JessieLin
 * @description 针对表【student_teacher】的数据库操作Service实现
 * @createDate 2022-04-09 20:52:06
 */
@Service
public class StudentTeacherServiceImpl extends ServiceImpl<StudentTeacherMapper, StudentTeacher>
        implements StudentTeacherService {

}




