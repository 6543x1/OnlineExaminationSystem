package com.jessie.onlineexaminationsystem.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.jessie.onlineexaminationsystem.domain.Result;
import com.jessie.onlineexaminationsystem.domain.Student;
import com.jessie.onlineexaminationsystem.domain.TeacherQuestionStore;
import com.jessie.onlineexaminationsystem.service.SelectionsService;
import com.jessie.onlineexaminationsystem.service.StudentService;
import com.jessie.onlineexaminationsystem.service.TeacherQuestionStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@SaCheckRole("teacher")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherQuestionStoreService teacherQuestionStoreService;
    @Autowired
    SelectionsService selectionsService;
    @Autowired
    StudentService studentService;

    @PostMapping("/createStore")
    public Result createStore(@RequestBody TeacherQuestionStore teacherQuestionStore) {
        teacherQuestionStore.setTeacher(Integer.parseInt((String) StpUtil.getLoginId("")));
        teacherQuestionStore.setUpdateTime(LocalDateTime.now());
        teacherQuestionStoreService.newQuestionStore(teacherQuestionStore);
        return Result.success("设置题库成功");
    }

    @PostMapping("/getStores")
    public Result getStores() {
        List<TeacherQuestionStore> list = teacherQuestionStoreService.getAllByTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        return Result.success("查询成功", list);
    }

    @PostMapping("/getStores2")
    public Result getStores2() {
        List<TeacherQuestionStore> list = teacherQuestionStoreService.getAllByTeacher(Integer.parseInt(StpUtil.getLoginId("")));
        return Result.success("查询成功", list);
    }

    @PostMapping("/getStoreQuestions")
    @Transactional
    public Result getStoresQuestions(@RequestBody Integer store) {

        return Result.success("查询成功", teacherQuestionStoreService.getAllQuestionByStore(store));
    }

    @PostMapping("/addStudents")
    public Result addStudents(@RequestBody List<Integer> students) {
//        List<TeacherQuestionStore> list=teacherQuestionStoreService.getAllByTeacher(Integer.parseInt( StpUtil.getLoginId("")));
        studentService.insertStuToTeacher(students, StpUtil.getLoginId(1));
        return Result.success("成功");

    }

    @PostMapping("/removeStudents")
    public Result removeStudents(@RequestBody List<Integer> students) {
//        List<TeacherQuestionStore> list=teacherQuestionStoreService.getAllByTeacher(Integer.parseInt( StpUtil.getLoginId("")));
        studentService.delete(students, StpUtil.getLoginId(1));
        return Result.success("成功");

    }

    @PostMapping("/getStudents")
    public Result getStudents() {
//        List<TeacherQuestionStore> list=teacherQuestionStoreService.getAllByTeacher(Integer.parseInt( StpUtil.getLoginId("")));
        List<Student> list = studentService.selectByTeacher(StpUtil.getLoginId(0));
        return Result.success("成功", list);

    }


//
//    @PostMapping("/newSelections")
//    public Result newSelections(@RequestBody List<Selections> selections){
//        int teacherID=StpUtil.getLoginId(Integer.valueOf(0));
//        for(Selections selections1:selections){
//            selections1.setTeacher(teacherID);
//        }
//        selectionsService.insertBatch(selections);
//        return Result.success("设置选择题题目成功");
//    }
//
//    @PostMapping("/searchSelections")
//    public Result searchSelections(@RequestBody String query){
//
//        return Result.success("搜索完成",selectionsService.searchSelections(query));
//    }
}
