package com.example.system.entity.dto.gift;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-13 10:12
 */
@Data
public class FrontGiftItemDTO {

    @ApiModelProperty("套餐id")
    private Integer id;

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐描述")
    private String desc;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty
    private Date endTime;

}
