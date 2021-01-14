package com.example.system.entity.dto.car;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 10:36
 */
@Data
public class CarInputDTO {

    @ApiModelProperty("汽车名称")
    @NotBlank(message = "汽车名称不能为空")
    private String name;

    @ApiModelProperty("汽车照片")
    @NotBlank(message = "汽车照片不能为空")
    private String photoUrl;

    @ApiModelProperty("租金")
    @NotNull(message = "租金不能为空")
    private Integer rent;

    @ApiModelProperty("状态|0=未租出|1=已租出")
    @NotNull(message = "状态不能为空")
    private Integer state;
}
