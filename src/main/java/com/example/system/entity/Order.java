package com.example.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

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
     * 租用天数
     */
    @TableField("rental_day")
    private Integer rentalDay;
    /**
     * 租金
     */
    @TableField("rental_money")
    private Integer rentalMoney;

}
