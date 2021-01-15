package com.example.system.entity;

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
    /**
     * 管理员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 管理员账号
     */
    @TableField("account")
    private String account;
    /**
     * 管理员密码
     */
    @TableField("password")
    private String password;
    /**
     * 管理员姓名
     */
    @TableField("name")
    private String name;
    /**
     * 管理员性别
     */
    @TableField("sex")
    private Character sex;
    /**
     * 管理员年龄
     */
    @TableField("age")
    private Integer age;
}
