package com.nzyjfw.o2o.controller;

import com.nzyjfw.o2o.dao.UserDao;
import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.User;
import com.nzyjfw.o2o.service.AuthService;
import com.nzyjfw.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 21:35
 */
@RestController
@RequestMapping("/auth")
public class JwtAuthController {
    @Resource
    private AuthService authService;

    @Resource
    private UserService userService;
    /**
     * 登录，获取Token
     * @param user 用户
     * @return Token
     */
    @PostMapping("/login")
    public Result createToken(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        Map<String, Object> result = new HashMap<>();
        String token = authService.login(username, password);
        if ("error".equals(token)) {
            return Result.error("账户或密码错误！");
        }
        User user1 = userService.findByUsername(username);
        result.put("token", token);
        result.put("username", user1.getUsername());
        result.put("isAdmin", user1.getRoles().contains("admin"));
        return Result.success("登录成功", result);
    }

    /**
     * 注册新用户
     * @param user 用户对象
     * @return 注册对象
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        User result = authService.register(user);
        if (result == null) {
            return Result.error( "账户已存在！");
        }
        return Result.success("注册成功", result);
    }
}
