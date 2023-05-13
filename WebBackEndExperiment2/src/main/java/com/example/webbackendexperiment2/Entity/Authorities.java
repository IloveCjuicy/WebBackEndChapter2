package com.example.webbackendexperiment2.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;

@Data
@Schema
public class Authorities implements Serializable
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String authority;
}
