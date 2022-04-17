package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Student;
import com.jessie.onlineexaminationsystem.domain.StudentTeacher;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【student_teacher】的数据库操作Mapper
 * @createDate 2022-04-09 20:52:06
 * @Entity com.jessie.onlineexaminationsystem.domain.StudentTeacher
 */
public interface StudentTeacherMapper extends BaseMapper<StudentTeacher> {
    int insertBatch(@Param("studentTeacherCollection") Collection<Integer> studentTeacherCollection, @Param("teacher") Integer teacher);

    List<Student> selectAllByTid(@Param("teacher") Integer teacher);

    int deleteBySid(@Param("studentTeacherCollection") Collection<Integer> studentTeacherCollection, @Param("teacher") Integer teacher);

}




