package com.jml.user.service.impl;

import com.jml.user.mapper.UserMapper;
import com.jml.user.model.User;
import com.jml.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User queryUserById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
