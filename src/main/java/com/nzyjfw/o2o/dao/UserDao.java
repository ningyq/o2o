package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.User;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface UserDao extends BaseMapper<User> {

    @Select("select * from `user` where username = #{username}")
    User findByUsername(String username);

    @Select("select count(*) from `user`")
    int count();
}