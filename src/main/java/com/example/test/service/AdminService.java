package com.example.test.service;

import com.example.test.entity.dto.CarAlertDTO;
import com.example.test.entity.dto.CarInputDTO;
import com.example.test.entity.dto.GiftInputDTO;
import com.example.test.entity.dto.UserAlertDTO;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:43
 */
public interface AdminService {
    /**
     * 新增车辆信息
     * @param inputDTO 车辆信息插入DTO
     */
    void addCar(CarInputDTO inputDTO);
    /**
     * 修改车辆信息
     * @param  alertDTO 车辆信息修改DTO
     */
    void alertCar(CarAlertDTO alertDTO);
    /**
     * 删除车辆信息
     * @param  carId 汽车id
     */
    void deleteCar(Integer carId);
    /**
     * 套餐发布
     * @param  inputDTO 套餐插入DTO
     */
    void addGift(GiftInputDTO inputDTO);
    /**
     * 修改普通用户信息
     * @param  alertDTO 用户信息修改DTO
     */
    void alertUser(UserAlertDTO alertDTO);
    /**
     * 删除普通用户信息
     * @param  userId 普通用户id
     */
    void deleteUser(Integer userId);


}
