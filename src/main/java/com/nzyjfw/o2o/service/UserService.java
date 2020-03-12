package com.nzyjfw.o2o.service;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface UserService {

    /**
     * 根据用户名
     *
     * @param username 用户名
     * @return 查找到的实体
     */
    User findByUsername(String username);

    /**
     * 分页查询所有
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 查询列表
     */
    PageInfo<User> selectAll(int pageNum, int pageSize);

    /**
     * 查询总数
     *
     * @return 查询列表
     */
    int selectCount();

    /**
     * 增加
     *
     * @param user 添加实体
     * @return 影响行数
     */
    boolean add(User user);

    /**
     * 更新
     *
     * @param user 实体
     * @return 影响行数
     */
    boolean update(User user);

}