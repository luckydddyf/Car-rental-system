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
 * @Date 2021-01-04 16:00
 */
@Data
@TableName("t_gift")
public class Gift{

    /**
     * 套餐id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 套餐名
     */
    @TableField("name")
    private String name;

    /**
     * 套餐描述
     */
    @TableField("desc")
    private String desc;

    /**
     * 套餐开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("start_time")
    private Date startTime;

    /**
     * 套餐结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("end_time")
    private Date endTime;

}
