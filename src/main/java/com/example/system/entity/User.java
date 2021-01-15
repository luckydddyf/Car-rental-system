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
@TableName("t_user")
public class User{
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户账号
     */
    @TableField("account")
    private String account;
    /**
     * 用户密码
     */
    @TableField("password")
    private String password;
    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;
    /**
     * 用户性别
     */
    @TableField("sex")
    private Character sex;
    /**
     * 用户年龄
     */
    @TableField("age")
    private Integer age;
}
