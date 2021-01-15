package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 15:54
 */
@Data
public class FrontUserItemDTO {

    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户账号")
    private String account;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private Character sex;
    @ApiModelProperty("年龄")
    private Integer age;

}
