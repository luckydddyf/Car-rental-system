package com.example.system.entity.dto.user;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 15:51
 */
@Data
public class UserPageInputDTO extends Pagination {

    @ApiModelProperty("用户姓名")
    private String name;
}
