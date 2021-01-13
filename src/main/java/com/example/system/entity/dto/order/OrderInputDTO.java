package com.example.system.entity.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-13 15:47
 */
@Data
public class OrderInputDTO {

    @ApiModelProperty("订单id")
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("汽车id")
    private Integer carId;

    @ApiModelProperty("租用时间")
    private Integer rentalDay;
}
