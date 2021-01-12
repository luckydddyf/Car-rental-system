package com.example.test.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 14:10
 */
@Data
public class UserInputDTO {

    @ApiModelProperty("用户姓名")
    private String name;
}
