package com.example.test.controller;

import com.example.test.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 15:58
 */
@RestController
@RequestMapping("/api/admin")
@Api(value = "/admin",tags = "管理员")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addCar")
    @ApiOperation("新增车辆信息")
    public void addCars(){
        adminService.addCar();
    }

    @PostMapping("/alertCar")
    @ApiOperation("修改车辆信息")
    public void alertCars(){
        adminService.alertCar();
    }


}
