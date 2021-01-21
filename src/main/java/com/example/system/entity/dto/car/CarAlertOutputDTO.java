package com.example.system.entity.dto.car;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-21 13:42
 */
@Data
public class CarAlertOutputDTO {

    @ApiModelProperty("汽车名称")
    private String name;

    @ApiModelProperty("汽车照片")
    private String photoUrl;

    @ApiModelProperty("日租金")
    private Integer rent;
}
