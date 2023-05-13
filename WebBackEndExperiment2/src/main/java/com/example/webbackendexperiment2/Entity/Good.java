package com.example.webbackendexperiment2.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema
public class Good implements Serializable
{
    @TableId(value = "id")
    private Object id;

    public Good(Object goodname, Object price, Object stock) {
        this.goodname = goodname;
        this.price = price;
        this.stock = stock;
    }

    private Object goodname;
    private Object price;
    private Object stock;

}