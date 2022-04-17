package com.jessie.onlineexaminationsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessie.onlineexaminationsystem.domain.User;
import com.jessie.onlineexaminationsystem.domain.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JessieLin
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2022-03-20 01:25:55
 * @Entity com.jessie.onlineexaminationsystem.domain.User
 */
public interface UserMapper extends BaseMapper<User> {

    User selectOnePasswordByUsername(@Param("username") String username);

    List<String> selectRoleByUid(@Param("uid") Integer uid);

    int insertAll(UserVO user);

    UserVO selectOneByUid(@Param("uid") Integer uid);

    int updateMailByUidOrUsername(@Param("mail") String mail, @Param("username") String username);

    int updateMailByUid(@Param("mail") String mail, @Param("uid") Integer uid);

}




