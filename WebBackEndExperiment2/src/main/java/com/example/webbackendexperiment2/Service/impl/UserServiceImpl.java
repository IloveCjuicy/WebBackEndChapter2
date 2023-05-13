package com.example.webbackendexperiment2.Service.impl;

import com.example.webbackendexperiment2.Entity.User;
import com.example.webbackendexperiment2.Mapper.UserMapper;
import com.example.webbackendexperiment2.Service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> findAllUsers()
    {
        return userMapper.findAllUsers();
    }

    @Override
    public User selectById(int id)
    {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByUserName(String username)
    {
        return userMapper.selectByUserName(username);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
