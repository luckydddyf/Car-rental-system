package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-21 13:45
 */
@Data
public class UserAlertOutputDTO {

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Character sex;

    @ApiModelProperty("年龄")
    private Integer age;
}
