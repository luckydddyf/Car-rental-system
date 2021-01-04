package com.example.test.service;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:43
 */
public interface AdminService {
    /**
     * 新增车辆信息
     */
    void addCar();
    /**
     * 修改车辆信息
     */
    void alertCar();
    /**
     * 删除车辆信息
     */
    void deleteCar(Integer carId);
    /**
     * 套餐发布
     */
    void addGift();
    /**
     * 修改普通用户信息
     */
    void alertUser();
    /**
     * 删除普通用户信息
     */
    void deleteUser(Integer userId);


}
