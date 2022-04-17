package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【course】的数据库操作Mapper
 * @createDate 2022-03-27 01:26:55
 * @Entity com.jessie.onlineexaminationsystem.domain.Course
 */
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> selectById(@Param("id") Integer id);

    int insertAll(Course course);

    List<Course> selectByTeacher(@Param("teacher") Integer teacher);
}




