package com.nzyjfw.o2o.service;

import com.nzyjfw.o2o.entity.UserInfo;


/**
 * (UserInfo)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface UserInfoService {

    /**
     * 根据用户名查找
     *
     * @param username 用户名
     * @return 查找到的实体
     */
    UserInfo findByUsername(String username);

    /**
     * 更新
     *
     * @param userInfo 实体
     * @return 影响行数
     */
    boolean update(UserInfo userInfo);
}