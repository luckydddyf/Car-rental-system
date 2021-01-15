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
    /**
     * 汽车id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 车名
     */
    @TableField("name")
    private String name;
    /**
     * 照片url
     */
    @TableField("photo_url")
    private String photoUrl;
    /**
     * 日租金
     */
    @TableField("rent")
    private Integer rent;
    /**
     * 汽车状态|0=未租出|1=已租出
     */
    @TableField("state")
    private Integer state;

}
