package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.Course;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【course】的数据库操作Service
 * @createDate 2022-03-27 01:26:55
 */
public interface CourseService extends IService<Course> {

    void newCourse(Course course);

    List<Course> getCourseByTeacher(Integer teacherID);
}
