package com.example.system.controller;

import com.example.system.entity.dto.gift.FrontGiftPageOutputDTO;
import com.example.system.entity.dto.gift.GiftAlertDTO;
import com.example.system.entity.dto.gift.GiftInputDTO;
import com.example.system.entity.dto.gift.GiftPageInputDTO;
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
 * @Date 2021-01-05 14:34
 */
@RestController
@RequestMapping("/api/gift")
@Api(value = "/gift",tags = {"优惠套餐管理"})
public class GiftController  {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation("套餐列表")
    public FrontGiftPageOutputDTO list(@RequestBody GiftPageInputDTO inputDTO){
        return userService.giftList(inputDTO);
    }

    @PostMapping("/add")
    @ApiOperation("套餐发布")
    public void addGifts(@RequestBody @Valid GiftInputDTO inputDTO){
        adminService.addGift(inputDTO);
    }

    @PostMapping("/alert")
    @ApiOperation("套餐修改")
    public void alertGifts(@RequestBody @Valid GiftAlertDTO alertDTO){
        adminService.alertGift(alertDTO);
    }

    @GetMapping("delete/{giftId}")
    @ApiOperation("套餐删除")
    public void deleteGifts(@PathVariable("giftId") Integer giftId){
        adminService.deleteGift(giftId);
    }

}
