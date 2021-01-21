package com.example.system.controller;

import com.example.system.entity.dto.car.*;
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
 * @Date 2021-01-04 15:58
 */
@RestController
@RequestMapping("/api/car")
@Api(value = "/car",tags = {"车辆信息管理"})
public class CarController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation("车辆信息列表")
    public FrontCarPageOutputDTO list(@RequestBody CarPageInputDTO inputDTO){
        return userService.carList(inputDTO);
    }

    @PostMapping("/add")
    @ApiOperation("新增车辆信息")
    public void addCars(@RequestBody @Valid CarInputDTO inputDTO){
        adminService.addCar(inputDTO);
    }

    @PostMapping("/alert")
    @ApiOperation("修改车辆信息")
    public void alertCars(@RequestBody @Valid CarAlertDTO alertDTO){
        adminService.alertCar(alertDTO);
    }

    @GetMapping("/alert/detail/{carId}")
    @ApiOperation("车辆信息回显")
    public CarAlertOutputDTO carOutput(@PathVariable("carId") Integer carId){
        return adminService.carOutput(carId);
    }

    @GetMapping("/delete/{carId}")
    @ApiOperation("删除车辆信息")
    public void deleteCars(@PathVariable("carId") Integer carId){
        adminService.deleteCar(carId);
    }

}
