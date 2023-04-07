package com.example.demo.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Pojo.Outbound;
import com.example.demo.Pojo.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OutboundDAO extends BaseMapper<Outbound> {
}
