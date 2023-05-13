package com.example.webbackendexperiment2.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webbackendexperiment2.Entity.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodMapper extends BaseMapper<Good>
{
    @Select("SELECT * FROM good where id=${id}")
    Good findById(@Param("id")Integer id);
    @Select("SELECT * FROM good")
    List<Good> findAllGoods();
    @Insert({"insert into good(goodname,price,stock) values(${goodname},${price},${stock})"})
    int insertGood(@Param("goodname")String goodname,@Param("price")Double price,@Param("stock")Integer stock);
    @Delete({"delete from good where id=${id}"})
    int deleteById(@Param("id")Integer id);
    @Update({"update good set price=${price},stock=${stock} where id=${id}"})
    int updateById(@Param("price")Double price,@Param("stock")Integer stock,@Param("id")Integer id);
    @Update({"update good set price=${price},stock=${stock} where goodname=#{goodname}"})
    int updateByGoodName(@Param("price")Double price,@Param("stock")Integer stock,@Param("goodname")String goodname);
}