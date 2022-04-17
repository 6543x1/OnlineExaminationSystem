package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.Student;
import com.jessie.onlineexaminationsystem.mapper.StudentMapper;
import com.jessie.onlineexaminationsystem.mapper.StudentTeacherMapper;
import com.jessie.onlineexaminationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2022-03-20 01:26:49
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentTeacherMapper studentTeacherMapper;

    @Override
    public List<Student> selectByStudent(Student student) {
        return studentMapper.selectAllBySchoolOrNoOrProfession(student.getSchool(), student.getNo(), student.getProfession(), student.getName());
    }

    @Override
    public void insertStuToTeacher(List<Integer> students, Integer teacher) {
        studentTeacherMapper.insertBatch(students, teacher);
    }

    @Override
    public List<Student> selectByTeacher(Integer teacher) {
        return studentTeacherMapper.selectAllByTid(teacher);
    }

    @Override
    public void delete(List<Integer> students, Integer teacher) {
        studentTeacherMapper.deleteBySid(students, teacher);
    }
}




