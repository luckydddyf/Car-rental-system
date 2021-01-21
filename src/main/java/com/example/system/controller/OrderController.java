package com.example.system.controller;

import com.example.system.entity.dto.car.CarDetailDTO;
import com.example.system.entity.dto.order.FrontOrderPageOutputDTO;
import com.example.system.entity.dto.order.OrderInputDTO;
import com.example.system.entity.dto.order.OrderPageInputDTO;
import com.example.system.entity.dto.user.UserDetailDTO;
import com.example.system.service.AdminService;
import com.example.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-15 14:31
 */
@RestController
@RequestMapping("/api/order")
@Api(value = "/order",tags = {"订单信息管理"})
public class OrderController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation("订单信息列表")
    public FrontOrderPageOutputDTO list(@RequestBody OrderPageInputDTO inputDTO){
        return adminService.orderList(inputDTO);
    }

    @PostMapping("/add")
    @ApiOperation("在线下单")
    public void addOrders(@RequestBody OrderInputDTO inputDTO){
        userService.orderOnline(inputDTO);
    }

    @GetMapping("/list/userDetail/{userId}")
    @ApiOperation("客户详情")
    public UserDetailDTO userDetail(@PathVariable("userId") Integer userId){
        return adminService.userDetail(userId);
    }

    @GetMapping("/list/carDetail/{carId}")
    @ApiOperation("汽车详情")
    public CarDetailDTO carDetail(@PathVariable("carId") Integer carId){
        return adminService.carDetail(carId);
    }
}
