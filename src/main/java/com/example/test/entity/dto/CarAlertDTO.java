package com.example.test.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 11:38
 */
@Data
public class CarAlertDTO {

    @ApiModelProperty("租金")
    private Integer rent;

    @ApiModelProperty("状态")
    private Integer state;
}
