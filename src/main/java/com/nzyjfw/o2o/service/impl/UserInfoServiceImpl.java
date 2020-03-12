package com.nzyjfw.o2o.service.impl;

import com.nzyjfw.o2o.dao.UserInfoDao;
import com.nzyjfw.o2o.entity.UserInfo;
import com.nzyjfw.o2o.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@Service("userInfoService")
@Transactional(rollbackFor=Exception.class)
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

    @Override
    public boolean update(UserInfo userInfo) {
        return userInfoDao.updateByPrimaryKeySelective(userInfo) > 0;
    }
}