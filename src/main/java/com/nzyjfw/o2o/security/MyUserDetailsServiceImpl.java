package com.nzyjfw.o2o.security;

import com.nzyjfw.o2o.dao.UserDao;
import com.nzyjfw.o2o.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 16:41
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在！");
        }
        return user;
    }
}
