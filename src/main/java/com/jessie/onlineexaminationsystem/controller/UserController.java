package com.jessie.onlineexaminationsystem.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.jessie.onlineexaminationsystem.domain.RegisterVO;
import com.jessie.onlineexaminationsystem.domain.Result;
import com.jessie.onlineexaminationsystem.domain.User;
import com.jessie.onlineexaminationsystem.domain.UserVO;
import com.jessie.onlineexaminationsystem.service.MailService;
import com.jessie.onlineexaminationsystem.service.UserService;
import com.jessie.onlineexaminationsystem.service.impl.MailServiceImpl;
import com.jessie.onlineexaminationsystem.utils.BCrypt;
import com.jessie.onlineexaminationsystem.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Deque;
import java.util.LinkedList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MailService mailService;

    @PostMapping("/login")
    public Result testLogin(@RequestBody User user) {
        if (userService.Login(user)) {
//            StpUtil.login(user.getUsername());
            return Result.success("登录成功"

                    , StpUtil.getTokenInfo());
        }
        return Result.error("用户名或密码错误！");

    }

    @SaCheckPermission("admin")
    @PostMapping("/isLogin")
    public Result isLogin() {
        Deque<Integer> deque = new LinkedList<>();

        return Result.success("success");
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserVO user) {
        userService.register(user);
        return Result.success("注册成功");
    }

    @PostMapping("/RealRegister1")
    public Result RealRegister(@RequestBody UserVO user) {
        redisUtil.set("register:" + user.getUsername(), JSON.toJSONString(user), 30 * 60);
        String code = MailServiceImpl.getRandomString();
        redisUtil.set("registerCode:" + user.getUsername(), code, 30 * 60);
        mailService.sendNewMessage(user.getMail(), "你的验证码是" + code);
//        userService.register(user);
        return Result.success("请到邮箱中查看", code);
    }

    @PostMapping("/RealRegister2")
    public Result RealRegister2(@RequestBody RegisterVO registerVO) {
        String realCode = redisUtil.get("registerCode:" + registerVO.getUsername());
        if (registerVO.getCode().equals(realCode)) {
            UserVO userVo = JSON.parseObject(redisUtil.get("register:" + registerVO.getUsername()), UserVO.class);
            userVo.setPassword(BCrypt.hashPw(userVo.getPassword()));
            userService.register(userVo);

            return Result.success("注册成功");
        }
//        userService.register(user);
        return Result.success("注册失败！检查验证码是否正确");
    }

    @PostMapping("/userinfo")
    @SaCheckRole("student")
    public Result getUserInfo() {
        Integer uid = StpUtil.getLoginId(0);
        return Result.success("成功！", userService.userinfo(uid));

    }

    @PostMapping("/setMail1")
    @SaCheckLogin
    public Result setMail(@RequestBody String mailAddr) {
        String code = MailServiceImpl.getRandomString();
        redisUtil.set("setMail:" + StpUtil.getLoginId(0), code, 30 * 60);
        redisUtil.set("setMailAddr:" + StpUtil.getLoginId(0), mailAddr, 30 * 60);
        try {
            mailService.sendNewMessage(mailAddr, "你的验证码是：" + code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.success("请到邮箱中查看信息", code);
    }

    @PostMapping("/setMail2")
    @SaCheckLogin
    public Result setMail2(@RequestBody String code) {
        String code2 = redisUtil.get("setMail:" + StpUtil.getLoginId(0));
        if (code2.equals(code)) {
            String mailAddr = redisUtil.get("setMailAddr:" + StpUtil.getLoginId(0));
            userService.updateMailAddrByUid(mailAddr, StpUtil.getLoginId(0));
            return Result.success("设置成功");
        }
        return Result.error("验证码不正确！！");

    }


}
