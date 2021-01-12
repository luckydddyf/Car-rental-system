package com.example.test.controller;

import com.example.test.entity.dto.GiftInputDTO;
import com.example.test.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 14:34
 */
@RestController
@RequestMapping("/api/gift")
@Api(value = "/gift",tags = {"优惠套餐管理"})
public class GiftController  {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addGift")
    @ApiOperation("套餐发布")
    public void addGifts(@RequestBody GiftInputDTO inputDTO){
        adminService.addGift(inputDTO);
    }


}
