package com.example.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.Gift;
import com.example.system.entity.User;
import com.example.system.entity.dto.car.CarAlertDTO;
import com.example.system.entity.dto.car.CarInputDTO;
import com.example.system.entity.dto.gift.GiftAlertDTO;
import com.example.system.entity.dto.gift.GiftInputDTO;
import com.example.system.entity.dto.order.FrontOrderPageOutputDTO;
import com.example.system.entity.dto.order.OrderPageInputDTO;
import com.example.system.entity.dto.user.FrontUserItemDTO;
import com.example.system.entity.dto.user.FrontUserPageOutputDTO;
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
import java.util.Optional;


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
        List<FrontUserItemDTO> list = new ArrayList<>();
        Wrapper<User> userWrapper = new EntityWrapper<>();
        userWrapper.like("name",inputDTO.getName());
        List<User> userList = userMapper.mixList(userWrapper,page);
        Optional.ofNullable(userList)
                .ifPresent(userLists -> {
                    userList.forEach(user -> {
                        FrontUserItemDTO item = new FrontUserItemDTO();
                        item.setId(user.getId());
                        item.setAccount(user.getAccount());
                        item.setName(user.getName());
                        item.setSex(user.getSex());
                        item.setAge(user.getId());
                        list.add(item);
                    });
                });
        page.setRecords(list);
        dto.setPage(page);
        return dto;
    }

    @Override
    public FrontOrderPageOutputDTO orderList(OrderPageInputDTO inputDTO){
        FrontOrderPageOutputDTO dto = new FrontOrderPageOutputDTO();
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCar(CarInputDTO inputDTO){
        Car car = new Car();
        car.setName(inputDTO.getName());
        car.setPhotoUrl(inputDTO.getPhotoUrl());
        car.setRent(inputDTO.getRent());
        car.setState(inputDTO.getState());
        carMapper.insert(car);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void alertCar(CarAlertDTO alertDTO){
        Car car = carMapper.selectById(alertDTO.getId());
        Optional.ofNullable(car)
                .ifPresent(alert -> {
                    car.setName(alertDTO.getName());
                    car.setPhotoUrl(alertDTO.getPhotoUrl());
                    car.setRent(alertDTO.getRent());
                    car.setState(alertDTO.getState());
                });
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
        Optional.ofNullable(gift)
                .ifPresent(alert -> {
                    gift.setName(alertDTO.getName());
                    gift.setDesc(alertDTO.getDesc());
                    gift.setStartTime(alertDTO.getStartTime());
                    gift.setEndTime(alertDTO.getEndTime());
                });
        giftMapper.updateById(gift);
    }

    @Override
    public void deleteGift(Integer giftId){
        giftMapper.deleteById(giftId);
    }

    @Override
    public void deleteUser(Integer userId){
        userMapper.deleteById(userId);
    }

}
