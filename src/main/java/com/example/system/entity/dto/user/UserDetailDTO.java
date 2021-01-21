package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-20 14:56
 */
@Data
public class UserDetailDTO {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("性别")
    private Character sex;

    @ApiModelProperty("年龄")
    private Integer age;
}
