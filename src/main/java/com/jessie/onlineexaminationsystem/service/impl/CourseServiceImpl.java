package com.jessie.onlineexaminationsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.Course;
import com.jessie.onlineexaminationsystem.mapper.CourseMapper;
import com.jessie.onlineexaminationsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【course】的数据库操作Service实现
 * @createDate 2022-03-27 01:26:55
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public void newCourse(Course course) {
        courseMapper.insertAll(course);
    }

    @Override
    public List<Course> getCourseByTeacher(Integer teacherID) {
        return courseMapper.selectByTeacher(teacherID);
    }

}




