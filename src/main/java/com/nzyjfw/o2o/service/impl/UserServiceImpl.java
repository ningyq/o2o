package com.nzyjfw.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dao.UserDao;
import com.nzyjfw.o2o.dao.UserInfoDao;
import com.nzyjfw.o2o.entity.User;
import com.nzyjfw.o2o.entity.UserInfo;
import com.nzyjfw.o2o.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public PageInfo<User> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(userDao.selectAll());
    }

    @Override
    public int selectCount() {
        return userDao.count();
    }

    @Override
    public boolean add(User user) {
        if (findByUsername(user.getUsername()) != null) {
            return false;
        }
        int num = userDao.insertSelective(user);
        if (num > 0) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(user.getUsername());
            userInfoDao.insertSelective(userInfo);
        }
        return num > 0;
    }

    @Override
    public boolean update(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }
}