package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 14:01
 */
@Data
public class UserSelfAlertDTO {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private char sex;

    @ApiModelProperty("年龄")
    private Integer age;

}
