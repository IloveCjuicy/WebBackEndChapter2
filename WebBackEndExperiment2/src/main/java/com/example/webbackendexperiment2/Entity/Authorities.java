package com.example.webbackendexperiment2.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Authorities
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String authority;
}
