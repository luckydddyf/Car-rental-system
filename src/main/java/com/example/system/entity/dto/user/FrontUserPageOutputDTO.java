package com.example.system.entity.dto.user;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 15:52
 */
@Data
public class FrontUserPageOutputDTO {

    @ApiModelProperty("用户信息分页列表")
    private Page<FrontUserItemDTO> page;
}
