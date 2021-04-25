package com.example.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.Gift;
import com.example.system.entity.Order;
import com.example.system.entity.User;
import com.example.system.entity.dto.car.CarAlertDTO;
import com.example.system.entity.dto.car.CarAlertOutputDTO;
import com.example.system.entity.dto.car.CarDetailDTO;
import com.example.system.entity.dto.car.CarInputDTO;
import com.example.system.entity.dto.gift.GiftAlertDTO;
import com.example.system.entity.dto.gift.GiftAlertOutputDTO;
import com.example.system.entity.dto.gift.GiftInputDTO;
import com.example.system.entity.dto.order.FrontOrderItemDTO;
import com.example.system.entity.dto.order.FrontOrderPageOutputDTO;
import com.example.system.entity.dto.order.OrderPageInputDTO;
import com.example.system.entity.dto.user.FrontUserItemDTO;
import com.example.system.entity.dto.user.FrontUserPageOutputDTO;
import com.example.system.entity.dto.user.UserDetailDTO;
import com.example.system.entity.dto.user.UserPageInputDTO;
import com.example.system.mapper.CarMapper;
import com.example.system.mapper.GiftMapper;
import com.example.system.mapper.OrderMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    private final String IMG_PATH = "D:/project/car-rental-system/src/main/resources/static/image";

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GiftMapper giftMapper;
    @Autowired
    private OrderMapper orderMapper;

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
        Page<FrontOrderItemDTO> page = new Page<>(inputDTO.getCurrent(),inputDTO.getSize());
        List<FrontOrderItemDTO> list = new ArrayList<>();
        Wrapper<Order> orderWrapper = new EntityWrapper<>();
        orderWrapper.ge("start_time",inputDTO.getStartTime())
                    .le("end_time",inputDTO.getEndTime());
        List<Order> orderList = orderMapper.mixList(orderWrapper,page);
        orderList.forEach(order -> {
            FrontOrderItemDTO item = new FrontOrderItemDTO();
            item.setId(order.getId());
            item.setStartTime(order.getStartTime());
            item.setEndTime(order.getEndTime());
            item.setUserId(order.getUserId());
            item.setCarId(order.getCarId());
            item.setRentalMoney(order.getRentalMoney());
            list.add(item);
        });
        page.setRecords(list);
        dto.setPage(page);
        return dto;
    }

    @Override
    public UserDetailDTO userDetail(Integer userId){
        UserDetailDTO dto = new UserDetailDTO();
        User user = userMapper.selectById(userId);
        dto.setName(user.getName());
        dto.setAccount(user.getAccount());
        dto.setSex(user.getSex());
        dto.setAge(user.getAge());
        return dto;
    }

    @Override
    public CarDetailDTO carDetail(Integer carId){
        CarDetailDTO dto = new CarDetailDTO();
        Car car = carMapper.selectById(carId);
        dto.setName(car.getName());
        dto.setPhotoUrl(car.getPhotoUrl());
        dto.setRent(car.getRent());
        dto.setState(car.getState());
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCar(CarInputDTO inputDTO,MultipartFile file){
        Car car = new Car();
        car.setName(inputDTO.getName());
        if(!file.isEmpty()) {
            try {
                String filePath = IMG_PATH  + "/" + file.getOriginalFilename();
                file.transferTo(new File(filePath));
                car.setPhotoUrl(filePath);
            } catch (IOException e) {
                log.info("-------------------------------io异常");
            }
        }
        car.setRent(inputDTO.getRent());
        car.setState(0);
        carMapper.insert(car);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void alertCar(CarAlertDTO alertDTO,MultipartFile file){
        Car car = carMapper.selectById(alertDTO.getId());
        Optional.ofNullable(car)
                .ifPresent(alert -> {
                    car.setName(alertDTO.getName());
                    car.setRent(alertDTO.getRent());
                    if(!file.isEmpty()) {
                        try {
                            String filePath = IMG_PATH  + "/" + file.getOriginalFilename();
                            file.transferTo(new File(filePath));
                            car.setPhotoUrl(filePath);
                        } catch (IOException e) {
                            log.info("-------------------------------io异常");
                        }
                    }
                });
        carMapper.updateById(car);
    }

    @Override
    public CarAlertOutputDTO carOutput(Integer carId){
        CarAlertOutputDTO dto = new CarAlertOutputDTO();
        Car car = carMapper.selectById(carId);
        dto.setName(car.getName());
        dto.setPhotoUrl(car.getPhotoUrl());
        dto.setRent(car.getRent());
        return dto;
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
    public GiftAlertOutputDTO giftOutput(Integer giftId){
        GiftAlertOutputDTO dto = new GiftAlertOutputDTO();
        Gift gift = giftMapper.selectById(giftId);
        dto.setName(gift.getName());
        dto.setDesc(gift.getDesc());
        dto.setStartTime(gift.getStartTime());
        dto.setEndTime(gift.getEndTime());
        return dto;
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
