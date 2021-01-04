package com.example.test.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 16:00
 */
@Data
@TableName("t_gift")
public class Gift extends BaseModel{
    @TableField("name")
    private String name;

}
