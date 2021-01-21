package com.example.system.controller;

import com.example.system.entity.dto.user.*;
import com.example.system.service.AdminService;
import com.example.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation("普通用户列表")
    public FrontUserPageOutputDTO list(@RequestBody UserPageInputDTO inputDTO){
        return adminService.userList(inputDTO);
    }

    @PostMapping("/add")
    @ApiOperation("用户注册")
    public void addUsers(@RequestBody @Valid UserInputDTO inputDTO){
        userService.addUser(inputDTO);
    }

    @PostMapping("/alert")
    @ApiOperation("修改个人信息")
    public void alertUserSelf(@RequestBody @Valid UserSelfAlertDTO alertDTO){
        userService.alertUserSelf(alertDTO);
    }

    @GetMapping("/alert/detail/{userId}")
    @ApiOperation("个人信息回显")
    public UserAlertOutputDTO userOutput(@PathVariable("userId") Integer userId){
        return userService.userOutput(userId);
    }

    @GetMapping("/delete/{userId}")
    @ApiOperation("删除普通用户")
    public void deleteUsers(@PathVariable("userId") Integer userId){
        adminService.deleteUser(userId);
    }
}
