package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.Student;
import com.jessie.onlineexaminationsystem.domain.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2022-03-20 01:26:49
 * @Entity com.jessie.onlineexaminationsystem.domain.Student
 */
public interface StudentMapper extends BaseMapper<Student> {
    int insertAll(Student student);

    int insertAll2(UserVO userVO);

    Student getOneById(@Param("id") Integer id);

    List<Student> selectAllBySchoolOrNoOrProfession(@Param("school") String school, @Param("no") String no, @Param("profession") String profession, @Param("name") String name);

    List<Student> selectStuInfoByExamID(@Param("cid") Integer cid);

    List<Student> selectAll();

}




