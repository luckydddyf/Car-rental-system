package com.example.system.entity.dto.gift;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-13 10:13
 */
@Data
public class FrontGiftPageOutputDTO {

    @ApiModelProperty("汽车信息分页列表")
    private Page<FrontGiftItemDTO> page;
}
