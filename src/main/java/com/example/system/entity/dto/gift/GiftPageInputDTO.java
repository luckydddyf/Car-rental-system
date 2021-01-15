package com.example.system.entity.dto.gift;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-13 10:12
 */
@Data
public class GiftPageInputDTO extends Pagination{

    @ApiModelProperty("套餐名称")
    private String name;

}
