package com.example.system.entity.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-12 14:10
 */
@Data
public class UserInputDTO {

    @ApiModelProperty("用户账号")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 6,max = 11,message = "密码长度必须是6-11个字符")
    private String account;

    @ApiModelProperty("用户密码")
    @NotBlank(message = "用户密码不能为空")
    @Size(min = 6,max = 11,message = "密码长度必须是6-11个字符")
    private String password;

    @ApiModelProperty("用户姓名")
    @NotBlank(message = "用户姓名不能为空")
    private String name;

    @ApiModelProperty("用户性别")
    @NotNull(message = "用户性别不能为空")
    private Character sex;

    @ApiModelProperty("用户年龄")
    @NotNull(message = "用户年龄不能为空")
    private Integer age;

}
