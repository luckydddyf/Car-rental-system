package com.example.test.service;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:42
 */
public interface UserService {
    /**
     * 新增用户(用户注册)
     */
    void addUser();
    /**
     * 修改个人信息
     */
    void alertUserSelf();
    /**
     * 在线下单
     */
    void orderOnline(Integer carId);

}
