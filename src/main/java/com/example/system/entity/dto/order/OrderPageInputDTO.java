package com.example.system.entity.dto.order;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-20 16:25
 */
@Data
public class OrderPageInputDTO extends Pagination {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("起租时间")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("截止时间")
    private Date endTime;
}
