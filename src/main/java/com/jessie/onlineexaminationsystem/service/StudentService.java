package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.Student;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【student】的数据库操作Service
 * @createDate 2022-03-20 01:26:49
 */
public interface StudentService extends IService<Student> {

    List<Student> selectByStudent(Student student);

    void insertStuToTeacher(List<Integer> students, Integer teacher);

    List<Student> selectByTeacher(Integer teacher);

    void delete(List<Integer> students, Integer teacher);
}
