package com.example.system.entity.dto.gift;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-13 10:05
 */
@Data
public class GiftAlertDTO {

    @ApiModelProperty("套餐id")
    @NotNull(message = "套餐id不能为空")
    private Integer id;

    @ApiModelProperty("套餐名称")
    @NotBlank(message = "套餐名称不能为空")
    private String name;

    @ApiModelProperty("套餐内容")
    @NotBlank(message = "套餐内容不能为空")
    private String desc;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("开始时间")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("结束时间")
    private Date endTime;
}
