package com.example.webbackendexperiment2.bo;

import com.example.webbackendexperiment2.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails
{
    private Object username;
    private Object password;
    private Boolean enabled;
    private List<GrantedAuthority> auths;

    public CustomUserDetails(User user,List<GrantedAuthority> auths) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.auths = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {

        return this.auths;
    }

    @Override
    public String getPassword() {
        return (String) password;
    }

    @Override
    public String getUsername() {
        return (String) username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

