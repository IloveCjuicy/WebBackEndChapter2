package com.example.webbackendexperiment2.Config;

import com.example.webbackendexperiment2.Service.ICustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private ICustomUserService customUserService;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserService);
    }
    // 配置 URL 访问权限
    @Override
    protected  void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/good/goodlist/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/good/user/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        // 用户访问其它URL都必须认证后访问（登录后访问）,认证会导致变为GET
                .and().formLogin().permitAll()
                // 开启表单登录并配置登录接口
                .and().csrf().disable(); // 关闭csrf
    }
}