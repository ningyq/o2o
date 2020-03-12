package com.nzyjfw.o2o.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2020-03-04 22:16:38
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 425554524223007047L;
    /**
     * 用户信息ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户性别
     */
    private Object sex;
    /**
     * 用户生日
     */
    private String birthday;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户地址
     */
    private String address;

}