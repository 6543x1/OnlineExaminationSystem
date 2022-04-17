package com.jessie.onlineexaminationsystem.config;

import cn.dev33.satoken.stp.StpInterface;
import com.jessie.onlineexaminationsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        if (loginId instanceof String)
            return userMapper.selectRoleByUid(Integer.parseInt((String) loginId));
        else {
            return userMapper.selectRoleByUid((Integer) loginId);
        }
    }
}
