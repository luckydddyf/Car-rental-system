package com.example.test.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;


/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:34
 */
@Data
@TableName("t_admin")
public class Admin{

    @TableId(value = "int_id", type = IdType.AUTO)
    private Integer id;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("sex")
    private char sex;
}
