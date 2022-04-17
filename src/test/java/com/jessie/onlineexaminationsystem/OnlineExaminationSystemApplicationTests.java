package com.jessie.onlineexaminationsystem;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jessie.onlineexaminationsystem.domain.Student;
import com.jessie.onlineexaminationsystem.domain.TeacherQuestionStoreVO;
import com.jessie.onlineexaminationsystem.domain.UserVO;
import com.jessie.onlineexaminationsystem.mapper.StudentMapper;
import com.jessie.onlineexaminationsystem.mapper.TeacherQuestionStoreMapper;
import com.jessie.onlineexaminationsystem.service.UserService;
import com.jessie.onlineexaminationsystem.utils.BCrypt;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class OnlineExaminationSystemApplicationTests {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserService userService;
    @Autowired
    TeacherQuestionStoreMapper teacherQuestionStoreMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testQueryStu() {
        Student student = studentMapper.getOneById(3);
        System.out.println(student.toString());
    }

    @Test
    void TestReg() {
        UserVO userVO = new UserVO();
        userVO.setMail("1647389906@qq.com");
        userVO.setName("学生2");
        userVO.setUsername("student2");
        userVO.setRole("student");
        userVO.setNo("233333");
        userVO.setPassword(BCrypt.hashPw("123456"));
        userVO.setProfession("测试用");
        userVO.setSchool("fzu");
        userService.register(userVO);
    }

    @Test
    public void complexStoreQuery() {

        List<TeacherQuestionStoreVO> teacherQuestionStoreVOS = teacherQuestionStoreMapper.selectOneById2(1);
        teacherQuestionStoreVOS.forEach(System.out::println);
        String jsonTarget = JSON.toJSONString(teacherQuestionStoreVOS, SerializerFeature.WriteClassName);
        System.out.println(jsonTarget);
        List<TeacherQuestionStoreVO> teacherQuestionStoreVOS1 = JSON.parseArray(jsonTarget, TeacherQuestionStoreVO.class);
        teacherQuestionStoreVOS1.forEach(System.out::println);
    }


}
