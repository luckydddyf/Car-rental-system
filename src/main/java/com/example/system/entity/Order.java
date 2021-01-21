package com.example.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 15:19
 */
@Data
@TableName("t_order")
public class Order {

    /**
     * 套餐id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 汽车id
     */
    @TableField("car_id")
    private Integer carId;

    /**
     * 起租时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("start_time")
    private Date startTime;

    /**
     * 截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("end_time")
    private Date endTime;

    /**
     * 租金
     */
    @TableField("rental_money")
    private Integer rentalMoney;

}
