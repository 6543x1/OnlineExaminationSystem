package com.jessie.onlineexaminationsystem.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.onlineexaminationsystem.domain.User;
import com.jessie.onlineexaminationsystem.domain.UserVO;
import com.jessie.onlineexaminationsystem.mapper.StudentMapper;
import com.jessie.onlineexaminationsystem.mapper.UserMapper;
import com.jessie.onlineexaminationsystem.service.UserService;
import com.jessie.onlineexaminationsystem.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JessieLin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-03-20 01:25:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean Login(User user) {
        User thisUser = userMapper.selectOnePasswordByUsername(user.getUsername());
        if (BCrypt.checkPw(user.getPassword(), thisUser.getPassword())) {
            StpUtil.login(thisUser.getUid());
//            StpUtil.checkPermission(thisUser.getRole());

            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public void register(UserVO userVO) {
        userMapper.insertAll(userVO);
        studentMapper.insertAll2(userVO);

    }


    @Override
    public UserVO userinfo(Integer uid) {
        return userMapper.selectOneByUid(uid);
    }

    @Override
    public void updateMailAddr(String mailAddr, String username) {
        userMapper.updateMailByUidOrUsername(mailAddr, username);
    }

    @Override
    public void updateMailAddrByUid(String mailAddr, Integer uid) {
        userMapper.updateMailByUid(mailAddr, uid);
    }
}




