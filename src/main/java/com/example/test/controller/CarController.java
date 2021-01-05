package com.example.test.controller;

import com.example.test.entity.dto.CarAlertDTO;
import com.example.test.entity.dto.CarInputDTO;
import com.example.test.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @ApiOperation("新增车辆信息")
    public void addCars(@RequestBody CarInputDTO inputDTO){
        adminService.addCar(inputDTO);
    }

    @PostMapping("/alert")
    @ApiOperation("修改车辆信息")
    public void alertCars(@RequestBody CarAlertDTO alertDTO){
        adminService.alertCar(alertDTO);
    }

    @PostMapping("/delete/{carId}")
    @ApiOperation("删除车辆信息")
    public void deleteCars(@PathVariable("carId") Integer carId){
        adminService.deleteCar(carId);
    }

}
