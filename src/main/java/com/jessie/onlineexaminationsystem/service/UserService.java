package com.jessie.onlineexaminationsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.onlineexaminationsystem.domain.User;
import com.jessie.onlineexaminationsystem.domain.UserVO;

/**
 * @author JessieLin
 * @description 针对表【user】的数据库操作Service
 * @createDate 2022-03-20 01:25:55
 */
public interface UserService extends IService<User> {

    boolean Login(User user);

    void register(UserVO userVO);

    UserVO userinfo(Integer uid);

    void updateMailAddr(String mailAddr, String username);

    void updateMailAddrByUid(String mailAddr, Integer uid);
}
