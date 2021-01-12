package com.example.test.service;

import com.example.test.entity.dto.UserInputDTO;
import com.example.test.entity.dto.UserSelfAlertDTO;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:42
 */
public interface UserService {
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
     */
    void orderOnline(Integer carId);

}
