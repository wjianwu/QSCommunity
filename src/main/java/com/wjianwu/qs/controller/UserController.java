package com.wjianwu.qs.controller;

import com.wjianwu.qs.common.Result;
import com.wjianwu.qs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-02-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录逻辑 Controller
     *
     * @param map account password
     * @return code
     */
    @RequestMapping("/login")
    public Result userLogin(@RequestBody Map map) {
        try {
            String username = (String) map.get("account");
            String password = (String) map.get("password");

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return Result.ok();
        } catch (Exception e) {
            return Result.error();
        }
    }

    /**
     * 注册逻辑 Controller
     *
     * @param map email/phone username password repeatPwd
     * @return code
     */
    @RequestMapping("/register")
    public Result UserRegister(@RequestBody Map map) {

        try {
            String account = (String) map.get("account");
            String username = (String) map.get("username");
            String password = (String) map.get("password");
            String repeatPwd = (String) map.get("repeatPwd");
            if (!password.equals(repeatPwd)) {
                return Result.error("两次密码不一样，请重新输入！");
            }
            if (userService.checkAccount(account)) {
                return Result.error("该账号已被注册！");
            }
            userService.addUser(account, username, password);
            return Result.ok();
        } catch (Exception e) {
            return Result.error();
        }
    }
}

