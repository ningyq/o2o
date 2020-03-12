package com.nzyjfw.o2o.service.impl;

import com.nzyjfw.o2o.dao.UserDao;
import com.nzyjfw.o2o.entity.User;
import com.nzyjfw.o2o.service.AuthService;
import com.nzyjfw.o2o.service.UserService;
import com.nzyjfw.o2o.utils.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 21:40
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private UserService userService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserDao userDao;

    @Override
    public User register(User user) {
        final String username = user.getUsername();
        if (userDao.findByUsername(username) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        if (!userService.add(user)) {
            return null;
        }
        return user;
    }

    @Override
    public String login(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);

            final Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            return "error";
        }
    }
}
