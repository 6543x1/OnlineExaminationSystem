package com.jessie.onlineexaminationsystem.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.jessie.onlineexaminationsystem.domain.Course;
import com.jessie.onlineexaminationsystem.domain.Result;
import com.jessie.onlineexaminationsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@SaCheckRole("teacher")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/newCourse")
    public Result newCourse(@RequestBody Course course) {
        course.setId(Integer.parseInt(StpUtil.getLoginId("")));
        courseService.newCourse(course);
        return Result.success("课程创建完成", course.getId());
    }

    @PostMapping("/getCourse")
    public Result getCourse(@RequestBody int teacher) {

        return Result.success("查询完成", courseService.getCourseByTeacher(teacher));
    }
}
