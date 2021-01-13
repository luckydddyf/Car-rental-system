package com.example.system.entity.dto.gift;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 11:16
 */
@Data
public class GiftInputDTO {

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐内容")
    private String desc;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;
}
