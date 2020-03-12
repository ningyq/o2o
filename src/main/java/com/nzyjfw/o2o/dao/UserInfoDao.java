package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.UserInfo;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * (UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface UserInfoDao extends BaseMapper<UserInfo> {

    @Select("select * from user_info where username = #{username}")
    UserInfo findByUsername(String username);

    @Delete("delete from user_info where username = #{username}")
    boolean deleteByUserId(String username);
}