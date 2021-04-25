package com.example.system.entity.dto.car;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 11:38
 */
@Data
public class CarAlertDTO {

    @ApiModelProperty("汽车id")
    @NotNull(message = "汽车id不能为空")
    private Integer id;

    @ApiModelProperty("汽车名称")
    @NotBlank(message = "汽车名称不能为空")
    private String name;

    @ApiModelProperty("日租金")
    @NotNull(message = "日租金不能为空")
    private Integer rent;

}
