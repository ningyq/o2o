package com.nzyjfw.o2o.controller;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.User;
import com.nzyjfw.o2o.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 查询所有
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 查询结果
     */
    @GetMapping("/all")
    public Result all(@RequestParam(defaultValue = "0") int pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<User> userList = userService.selectAll(pageNum, pageSize);

        return Result.success("获取成功！", userList);
    }

    /**
     * 查询
     *
     * @param username 用户名
     * @return 查询结果
     */
    @GetMapping("/username")
    public Result getOne(String username) {
        User user = userService.findByUsername(username);

        return Result.success("获取成功！", user);
    }

    /**
     * 查询总数
     *
     * @return 查询结果
     */
    @GetMapping("/count")
    public Result count() {
        int count = userService.selectCount();
        return Result.success("获取成功！", count);
    }


    /**
     * 添加
     *
     * @param user 实体
     * @return 是否成功
     */
//    @PostMapping("/add")
//    public Result add(@RequestBody User user) {
//        boolean tag = userService.add(user);
//        if (tag) {
//            return Result.success("添加成功！");
//        } else {
//            return Result.error("添加失败");
//        }
//    }

    /**
     * 更新
     *
     * @param user 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        boolean tag = userService.update(user);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败");
        }
    }
}