package com.example.webbackendexperiment2.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webbackendexperiment2.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User>
{
    @Select("SELECT * FROM user")
    List<User> findAllUsers();

    @Select("SELECT * FROM user where id=${id}")
    User selectById(@Param("id")int id);

    @Select("SELECT * FROM user where username='${username}'")
    User selectByUserName(@Param("username")String username);

    @Insert({"insert into `user`(username,password) values(#{username},#{password})"})
    int insertUser(User user);

    @Delete({"delete from `user` where username=#{username} and password=#{password}"})
    int deleteUser(User user);

    @Update({"update `user`  set password=#{password} where username=#{username}"})
    int updateUser(User user);
}

