package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 14:01
 */
@Data
public class UserSelfAlertDTO {

    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Integer id;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6,max = 11,message = "密码长度必须是6-11个字符")
    private String password;

    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty("性别")
    @NotNull(message = "性别不能为空")
    private Character sex;

    @ApiModelProperty("年龄")
    @NotNull(message = "年龄不能为空")
    private Integer age;

}
