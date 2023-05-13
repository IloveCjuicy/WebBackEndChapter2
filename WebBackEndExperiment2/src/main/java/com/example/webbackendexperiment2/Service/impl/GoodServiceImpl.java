package com.example.webbackendexperiment2.Service.impl;

import com.example.webbackendexperiment2.Entity.Good;
import com.example.webbackendexperiment2.Mapper.AuthoritiesMapper;
import com.example.webbackendexperiment2.Mapper.GoodMapper;
import com.example.webbackendexperiment2.Mapper.UserMapper;
import com.example.webbackendexperiment2.Service.IGoodService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements IGoodService
{
    @Resource
    GoodMapper goodMapper;
    @Override
    @Cacheable(key="#id",value = "good",unless = "#result==null")
    public Good findById(Integer id)
    {
        return goodMapper.selectById(id);
    }

    @Override
    public List<Good> findAllGoods()
    {
        return goodMapper.findAllGoods();
    }

    @Override
    @CachePut(key="#goodname",value = "goodname")
    public int insertGood(String goodname, Double price, Integer stock)
    {
        return goodMapper.insertGood(goodname, price, stock);
    }

    @Override
    @CacheEvict(key="#id",value = "goodname")
    public int deleteById(Integer id)
    {
        return goodMapper.deleteById(id);
    }

    @Override
    @CachePut(key = "#id",value = "goodname")
    public int updateById(Double price, Integer stock, Integer id) {
        return goodMapper.updateById(price, stock, id);
    }

    @Override
    @CachePut(key="#goodname",value = "goodname")
    public int updateByGoodName(Double price, Integer stock, String goodname) {
        return goodMapper.updateByGoodName(price, stock, goodname);
    }
}
