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

    @TableId(value = "int_id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("car_id")
    private Integer carId;

}
