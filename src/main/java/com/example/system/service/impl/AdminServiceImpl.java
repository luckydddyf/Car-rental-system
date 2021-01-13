package com.example.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.Gift;
import com.example.system.entity.dto.car.CarAlertDTO;
import com.example.system.entity.dto.car.CarInputDTO;
import com.example.system.entity.dto.gift.GiftAlertDTO;
import com.example.system.entity.dto.gift.GiftInputDTO;
import com.example.system.entity.dto.user.FrontUserItemDTO;
import com.example.system.entity.dto.user.FrontUserPageOutputDTO;
import com.example.system.entity.dto.user.UserAlertDTO;
import com.example.system.entity.dto.user.UserPageInputDTO;
import com.example.system.mapper.CarMapper;
import com.example.system.mapper.GiftMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:46
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GiftMapper giftMapper;


    @Override
    public FrontUserPageOutputDTO userList(UserPageInputDTO inputDTO){
        FrontUserPageOutputDTO dto = new FrontUserPageOutputDTO();
        Page<FrontUserItemDTO> page = new Page<>(inputDTO.getCurrent(),inputDTO.getSize());
        List<FrontUserItemDTO> userList = new ArrayList<>();

        page.setRecords(userList);
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCar(CarInputDTO inputDTO){
        Car car = new Car();
        car.setName(inputDTO.getName());
        car.setRent(inputDTO.getRent());
        car.setState(inputDTO.getState());
        carMapper.insert(car);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void alertCar(CarAlertDTO alertDTO){
        Car car = carMapper.selectById(alertDTO.getId());
        car.setName(alertDTO.getName());
        car.setRent(alertDTO.getRent());
        car.setState(alertDTO.getState());
        carMapper.updateById(car);
    }

    @Override
    public void deleteCar(Integer carId){
        carMapper.deleteById(carId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGift(GiftInputDTO inputDTO){
        Gift gift = new Gift();
        gift.setName(inputDTO.getName());
        gift.setDesc(inputDTO.getDesc());
        gift.setStartTime(inputDTO.getStartTime());
        gift.setEndTime(inputDTO.getEndTime());
        giftMapper.insert(gift);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void alertGift(GiftAlertDTO alertDTO){
        Gift gift = giftMapper.selectById(alertDTO.getId());
        gift.setName(alertDTO.getName());
        gift.setDesc(alertDTO.getDesc());
        gift.setStartTime(alertDTO.getStartTime());
        gift.setEndTime(alertDTO.getEndTime());
        giftMapper.updateById(gift);
    }

    @Override
    public void deleteGift(Integer giftId){
        giftMapper.deleteById(giftId);
    }

    @Override
    public void alertUser(UserAlertDTO alertDTO){ }

    @Override
    public void deleteUser(Integer userId){
        userMapper.deleteById(userId);
    }

}
