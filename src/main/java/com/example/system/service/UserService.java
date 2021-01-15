package com.example.system.service;

import com.example.system.entity.dto.gift.FrontGiftPageOutputDTO;
import com.example.system.entity.dto.gift.GiftPageInputDTO;
import com.example.system.entity.dto.order.OrderInputDTO;
import com.example.system.entity.dto.user.UserInputDTO;
import com.example.system.entity.dto.user.UserSelfAlertDTO;
import com.example.system.entity.dto.car.CarPageInputDTO;
import com.example.system.entity.dto.car.FrontCarPageOutputDTO;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:42
 */
public interface UserService {
    /**
     *
     * @param inputDTO 搜索条件
     * @return 汽车信息列表
     */
    FrontCarPageOutputDTO carList(CarPageInputDTO inputDTO);

    /**
     *
     * @param inputDTO 搜索条件
     * @return 套餐信息列表
     */
    FrontGiftPageOutputDTO giftList(GiftPageInputDTO inputDTO);

    /**
     * 新增用户(用户注册)
     * @param inputDTO 用户注册DTO
     */
    void addUser(UserInputDTO inputDTO);

    /**
     * 修改个人信息
     * @param alertDTO 修改个人信息DTO
     */
    void alertUserSelf(UserSelfAlertDTO alertDTO);

    /**
     * 在线下单
     * @param inputDTO 在线下单DTO
     */
    void orderOnline(OrderInputDTO inputDTO);

}
