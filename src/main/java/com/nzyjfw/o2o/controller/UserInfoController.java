package com.nzyjfw.o2o.controller;

import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.UserInfo;
import com.nzyjfw.o2o.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserInfo)表控制层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@RestController
@RequestMapping("/info")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 查找用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/username")
    public Result findByUsername(String username) {
        UserInfo userInfo = userInfoService.findByUsername(username);
        return Result.success("获取成功！", userInfo);
    }

    /**
     * 更新
     *
     * @param userInfo 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserInfo userInfo) {
        boolean tag = userInfoService.update(userInfo);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败");
        }
    }
}