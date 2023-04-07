package com.example.demo.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//定义数据层接口与映射配置
//需要在DAO层添加Mapper注解
@Component
@Mapper
public interface UserDAO extends BaseMapper<User> {
}
