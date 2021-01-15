package com.example.system.entity.dto.car;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 15:25
 */
@Data
public class FrontCarItemDTO {

    @ApiModelProperty("汽车id")
    private Integer id;
    @ApiModelProperty("汽车名称")
    private String name;
    @ApiModelProperty("汽车照片")
    private String photo_url;
    @ApiModelProperty("日租金")
    private Integer rent;
    @ApiModelProperty("汽车状态")
    private Integer state;


}
