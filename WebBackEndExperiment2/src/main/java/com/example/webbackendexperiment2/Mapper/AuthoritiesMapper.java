package com.example.webbackendexperiment2.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webbackendexperiment2.Entity.Authorities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthoritiesMapper extends BaseMapper<Authorities>
{
    @Select("SELECT authority FROM authorities inner join user on user.id=authorities.id where user.id=${id}")
    String SelectAuthorityByID(@Param("id")int id);

}
