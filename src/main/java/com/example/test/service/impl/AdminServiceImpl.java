package com.example.test.service.impl;

import com.example.test.entity.Car;
import com.example.test.entity.dto.CarAlertDTO;
import com.example.test.entity.dto.CarInputDTO;
import com.example.test.entity.dto.GiftInputDTO;
import com.example.test.entity.dto.UserAlertDTO;
import com.example.test.mapper.AdminMapper;
import com.example.test.mapper.CarMapper;
import com.example.test.mapper.UserMapper;
import com.example.test.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:46
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addCar(CarInputDTO inputDTO){
        Car car = new Car();
        car.setName(inputDTO.getName());
        car.setRent(inputDTO.getRent());
        car.setState(inputDTO.getState());
        carMapper.insert(car);
    }

    @Override
    public void alertCar(CarAlertDTO alertDTO){
    }

    @Override
    public void deleteCar(Integer carId){
    }

    @Override
    public void addGift(GiftInputDTO inputDTO){

    }

    @Override
    public void alertUser(UserAlertDTO alertDTO){

    }

    @Override
    public void deleteUser(Integer userId){

    }

}
