package com.example.demo.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Pojo.BackDetail;
import com.example.demo.Pojo.ReturnDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ReturnDetailDAO extends BaseMapper<ReturnDetail> {
}
