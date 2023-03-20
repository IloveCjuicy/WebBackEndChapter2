package com.example.webbackendexperiment2.Model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Good
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