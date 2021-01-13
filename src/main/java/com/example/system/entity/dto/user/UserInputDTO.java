package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 14:10
 */
@Data
public class UserInputDTO {

    @ApiModelProperty("用户账号")
    private String account;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户性别")
    private char sex;

    @ApiModelProperty("用户年龄")
    private Integer age;

}
