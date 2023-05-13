package com.example.webbackendexperiment2.Service;

import com.example.webbackendexperiment2.Entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodService
{
    Good findById(Integer id);
    List<Good> findAllGoods();
    int insertGood(String goodname, Double price, Integer stock);
    int deleteById(Integer id);
    int updateById(Double price,Integer stock,Integer id);
    int updateByGoodName(Double price,Integer stock,String goodname);
}
