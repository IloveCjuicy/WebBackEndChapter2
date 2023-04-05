package com.example.webbackendexperiment2.Service;

import com.example.webbackendexperiment2.Entity.Authorities;
import com.example.webbackendexperiment2.Entity.User;
import com.example.webbackendexperiment2.Mapper.AuthoritiesMapper;
import com.example.webbackendexperiment2.Mapper.UserMapper;
import com.example.webbackendexperiment2.bo.CustomUserDetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomUserService implements UserDetailsService {
    @Resource
    UserMapper usersMapper;

    @Resource
    AuthoritiesMapper authoritiesMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //selectById是按主键搜索，用户表的主键就是username
        User user = usersMapper.selectByUserName(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("用户名不存在");
        }

        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        String encodePassword = passwordEncoder.encode((CharSequence) user.getPassword());
        user.setPassword(encodePassword);

        //查找当前用户名对应的权限列表

        List<GrantedAuthority> authos=new ArrayList<>();
        authos.add(new SimpleGrantedAuthority(authoritiesMapper.SelectAuthorityByID((Integer) user.getId())));
        return new CustomUserDetails(user,authos);
    }
}
