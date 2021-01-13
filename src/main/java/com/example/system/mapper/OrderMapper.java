package com.example.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.system.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-13 15:33
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
