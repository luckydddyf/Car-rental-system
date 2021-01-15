package com.example.system.entity.dto.car;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 15:10
 */
@Data
public class CarPageInputDTO extends Pagination {

    @ApiModelProperty("汽车名称")
    private String name;

}
