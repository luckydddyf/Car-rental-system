package com.example.system.entity.dto.gift;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-21 13:44
 */
@Data
public class GiftAlertOutputDTO {

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐内容")
    private String desc;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("开始时间")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("结束时间")
    private Date endTime;
}
