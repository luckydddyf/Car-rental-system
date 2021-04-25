package com.example.system.service;

import com.example.system.entity.dto.car.CarAlertDTO;
import com.example.system.entity.dto.car.CarAlertOutputDTO;
import com.example.system.entity.dto.car.CarDetailDTO;
import com.example.system.entity.dto.car.CarInputDTO;
import com.example.system.entity.dto.gift.GiftAlertDTO;
import com.example.system.entity.dto.gift.GiftAlertOutputDTO;
import com.example.system.entity.dto.gift.GiftInputDTO;
import com.example.system.entity.dto.order.FrontOrderPageOutputDTO;
import com.example.system.entity.dto.order.OrderPageInputDTO;
import com.example.system.entity.dto.user.FrontUserPageOutputDTO;
import com.example.system.entity.dto.user.UserDetailDTO;
import com.example.system.entity.dto.user.UserPageInputDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:43
 */
public interface AdminService {

    /**
     * 用户信息列表
     * @param inputDTO 搜索条件
     * @return 用户信息列表
     */
    FrontUserPageOutputDTO userList(UserPageInputDTO inputDTO);

    /**
     * 订单信息列表
     * @param inputDTO 搜索条件
     * @return 订单信息列表
     */
    FrontOrderPageOutputDTO orderList(OrderPageInputDTO inputDTO);

    /**
     * 用户详情
     * @param userId 用户id
     * @return 用户详情
     */
    UserDetailDTO userDetail(Integer userId);

    /**
     * 汽车详情
     * @param carId 汽车id
     * @return 汽车详情
     */
    CarDetailDTO carDetail(Integer carId);

    /**
     * 新增车辆信息
     * @param inputDTO 车辆信息插入DTO
     * @param file 上传汽车图片
     */
    void addCar(CarInputDTO inputDTO,MultipartFile file);

    /**
     * 修改车辆信息
     * @param  alertDTO 车辆信息修改DTO
     * @param  file 上传汽车图片
     */
    void alertCar(CarAlertDTO alertDTO,MultipartFile file);

    /**
     * 车辆信息详情
     * @param carId 汽车id
     * @return 车辆信息详情
     */
    CarAlertOutputDTO carOutput(Integer carId);

    /**
     * 删除车辆信息
     * @param carId 汽车id
     */
    void deleteCar(Integer carId);

    /**
     * 发布套餐
     * @param  inputDTO 套餐插入DTO
     */
    void addGift(GiftInputDTO inputDTO);

    /**
     * 修改套餐
     * @param alertDTO 套餐修改DTO
     */
    void alertGift(GiftAlertDTO alertDTO);

    /**
     * 套餐信息详情
     * @param giftId 套餐id
     * @return 套餐信息详情
     */
    GiftAlertOutputDTO giftOutput(Integer giftId);

    /**
     * 删除套餐
     * @param giftId 套餐id
     */
    void deleteGift(Integer giftId);

    /**
     * 删除普通用户信息
     * @param  userId 普通用户id
     */
    void deleteUser(Integer userId);

}
