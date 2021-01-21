package com.example.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Order;
import com.example.system.entity.dto.order.FrontOrderItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author luckydddyfs
 * @Date 2021-01-13 15:33
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     *  mixList
     * @param ew 条件构造器
     * @param page
     * @return
     */
    @Select("select o.id id,o.user_id userId,o.car_id carId,o.start_time startTime,o.end_time endTime,o.rental_money rentalMoney " +
            "from t_order o " +
            "where 1 = 1 ${ew.sqlSegment}")
    List<Order> mixList(@Param("ew") Wrapper<Order> ew, @Param("page") Page<FrontOrderItemDTO> page);

    /**
     * selectEndTime
     * @param ew
     * @return
     */
    @Select("select o.end_time endTime " +
            "from t_order o " +
            "where 1=1 ${ew.sqlSegment}")
    Date selectEndTime(@Param("ew") Wrapper<Order> ew);
}
