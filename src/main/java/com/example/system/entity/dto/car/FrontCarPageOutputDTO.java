package com.example.system.entity.dto.car;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 15:14
 */
@Data
public class FrontCarPageOutputDTO {

    @ApiModelProperty("汽车信息分页列表")
    private Page<FrontCarItemDTO> frontCarPage;

}
