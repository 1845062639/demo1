package com.example.demo.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Pojo.BackDetail;
import com.example.demo.Pojo.OutboundDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OutboundDetailDAO extends BaseMapper<OutboundDetail> {
}
