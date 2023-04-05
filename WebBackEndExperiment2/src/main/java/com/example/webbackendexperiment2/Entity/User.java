package com.example.webbackendexperiment2.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User
{
    @TableId(value = "id")
    private Object id;
    private Object username;
    private Object password;
    private Boolean enabled;

    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
}
