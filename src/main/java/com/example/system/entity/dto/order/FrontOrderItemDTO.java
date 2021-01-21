package com.example.system.entity.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-15 14:38
 */
@Data
public class FrontOrderItemDTO {

    @ApiModelProperty("订单id")
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("起租时间")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("截止时间")
    private Date endTime;

    @ApiModelProperty("客户id")
    private Integer userId;

    @ApiModelProperty("汽车id")
    private Integer carId;

    @ApiModelProperty("租金")
    private Integer rentalMoney;
}
