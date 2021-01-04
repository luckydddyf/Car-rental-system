package com.example.test.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 13:32
 */
@Data
@TableName("t_user")
public class User extends BaseModel{
    @TableField("name")
    private String name;
    @TableField("sex")
    private Character sex;
}
