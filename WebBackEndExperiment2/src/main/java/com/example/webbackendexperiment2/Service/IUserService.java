package com.example.webbackendexperiment2.Service;


import com.example.webbackendexperiment2.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserService
{
    List<User> findAllUsers();

    User selectById(int id);


    User selectByUserName(String username);

    int insertUser(User user);

    int deleteUser(User user);

    int updateUser(User user);
}
