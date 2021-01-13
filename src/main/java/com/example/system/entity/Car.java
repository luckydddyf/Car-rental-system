package com.example.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 13:32
 */
@Data
@TableName("t_car")
public class Car{

    @TableId(value = "int_id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("photo_url")
    private String photoUrl;

    @TableField("rent")
    private Integer rent;

    @TableField("state")
    private Integer state;

}
