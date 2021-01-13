package com.example.system.controller;

import com.example.system.entity.dto.user.FrontUserPageOutputDTO;
import com.example.system.entity.dto.user.UserAlertDTO;
import com.example.system.entity.dto.user.UserPageInputDTO;
import com.example.system.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 14:21
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "/user",tags = {"普通用户管理"})
public class UserController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/list")
    @ApiOperation("普通用户列表")
    public FrontUserPageOutputDTO list(UserPageInputDTO inputDTO){
        return adminService.userList(inputDTO);
    }

    @PostMapping("/alert")
    @ApiOperation("修改普通用户信息")
    public void alertUsers(@RequestBody UserAlertDTO alertDTO){
        adminService.alertUser(alertDTO);
    }

    @GetMapping("/delete/{userId}")
    @ApiOperation("删除普通用户信息")
    public void deleteUsers(@PathVariable("userId") Integer userId){
        adminService.deleteUser(userId);
    }
}
