package com.example.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.Order;
import com.example.system.entity.User;
import com.example.system.entity.dto.car.FrontCarItemDTO;
import com.example.system.entity.dto.gift.FrontGiftItemDTO;
import com.example.system.entity.dto.gift.FrontGiftPageOutputDTO;
import com.example.system.entity.dto.gift.GiftPageInputDTO;
import com.example.system.entity.dto.order.OrderInputDTO;
import com.example.system.entity.dto.user.UserInputDTO;
import com.example.system.entity.dto.user.UserSelfAlertDTO;
import com.example.system.entity.dto.car.CarPageInputDTO;
import com.example.system.entity.dto.car.FrontCarPageOutputDTO;
import com.example.system.mapper.CarMapper;
import com.example.system.mapper.OrderMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 16:42
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public FrontGiftPageOutputDTO giftList(GiftPageInputDTO inputDTO){
        FrontGiftPageOutputDTO dto = new FrontGiftPageOutputDTO();
        Page<FrontGiftItemDTO> page = new Page<>(inputDTO.getCurrent(),inputDTO.getSize());
        List<FrontGiftItemDTO> giftList = new ArrayList<>();

        page.setRecords(giftList);
        return  dto;
    }

    @Override
    public FrontCarPageOutputDTO carList(CarPageInputDTO inputDTO){
        FrontCarPageOutputDTO dto = new FrontCarPageOutputDTO();
        Page<FrontCarItemDTO> page = new Page<>(inputDTO.getCurrent(),inputDTO.getSize());
        List<FrontCarItemDTO> carList = new ArrayList<>();

        page.setRecords(carList);
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserInputDTO inputDTO){
        User user = new User();
        user.setAccount(inputDTO.getAccount());
        user.setPassword(inputDTO.getPassword());
        user.setName(inputDTO.getName());
        user.setSex(inputDTO.getSex());
        user.setAge(inputDTO.getAge());
        userMapper.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void alertUserSelf(UserSelfAlertDTO alertDTO){
        User user = userMapper.selectById(alertDTO.getId());
        user.setPassword(alertDTO.getPassword());
        user.setName(alertDTO.getName());
        user.setSex(alertDTO.getSex());
        user.setAge(alertDTO.getAge());
        userMapper.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void orderOnline(OrderInputDTO inputDTO){
        Car orderCar = carMapper.selectById(inputDTO.getCarId());
        orderCar.setState(1);
        carMapper.updateById(orderCar);
        Integer rent = orderCar.getRent();
        Order order = new Order();
        order.setUserId(inputDTO.getUserId());
        order.setCarId(inputDTO.getCarId());
        order.setRentalDay(inputDTO.getRentalDay());
        order.setRentalMoney(inputDTO.getRentalDay() * rent);
        orderMapper.insert(order);
    }
}
