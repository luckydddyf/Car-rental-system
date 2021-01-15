package com.example.system.entity.dto.order;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-15 14:34
 */
@Data
public class FrontOrderPageOutputDTO {

    @ApiModelProperty("订单信息分页列表")
    private Page<FrontOrderItemDTO> page;
}
