package com.example.webbackendexperiment2.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ICustomUserService extends UserDetailsService
{
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
