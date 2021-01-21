package com.example.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.Gift;
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
import com.example.system.mapper.GiftMapper;
import com.example.system.mapper.OrderMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    private GiftMapper giftMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public FrontGiftPageOutputDTO giftList(GiftPageInputDTO inputDTO){
        FrontGiftPageOutputDTO dto = new FrontGiftPageOutputDTO();
        Page<FrontGiftItemDTO> page = new Page<>(inputDTO.getCurrent(),inputDTO.getSize());
        List<FrontGiftItemDTO> list = new ArrayList<>();
        Wrapper<Gift> giftWrapper = new EntityWrapper<>();
        giftWrapper.like("name",inputDTO.getName());
        List<Gift> giftList = giftMapper.mixList(giftWrapper,page);
        Optional.ofNullable(giftList)
                .ifPresent(giftLists -> {
                    giftList.forEach(gift -> {
                        FrontGiftItemDTO item = new FrontGiftItemDTO();
                        item.setId(gift.getId());
                        item.setName(gift.getName());
                        item.setDesc(gift.getDesc());
                        item.setStartTime(gift.getStartTime());
                        item.setEndTime(gift.getEndTime());
                        list.add(item);
                    });
                });
        page.setRecords(list);
        dto.setPage(page);
        return dto;
    }

    @Override
    public FrontCarPageOutputDTO carList(CarPageInputDTO inputDTO){
        FrontCarPageOutputDTO dto = new FrontCarPageOutputDTO();
        Page<FrontCarItemDTO> page = new Page<>(inputDTO.getCurrent(),inputDTO.getSize());
        List<FrontCarItemDTO> list = new ArrayList<>();
        //修改到期的车辆状态
        Wrapper<Car> carStateWrapper = new EntityWrapper<>();
        carStateWrapper.eq("state",1);
        List<Car> carList = carMapper.selectList(carStateWrapper);
        updateCarState(carList);
        //用户可根据车名查询
        Wrapper<Car> carWrapper = new EntityWrapper<>();
        carWrapper.like("name",inputDTO.getName());
        List<Car> pageCarList = carMapper.mixList(carWrapper,page);
        Optional.ofNullable(pageCarList)
                .ifPresent(carLists -> {
                    pageCarList.forEach(car -> {
                        FrontCarItemDTO item = new FrontCarItemDTO();
                        item.setId(car.getId());
                        item.setName(car.getName());
                        item.setPhoto_url(car.getPhotoUrl());
                        item.setRent(car.getRent());
                        item.setState(car.getState());
                        list.add(item);
                    });
                });
        page.setRecords(list);
        dto.setPage(page);
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
        Optional.ofNullable(user)
                .ifPresent(alert -> {
                    user.setPassword(alertDTO.getPassword());
                    user.setName(alertDTO.getName());
                    user.setSex(alertDTO.getSex());
                    user.setAge(alertDTO.getAge());
                });
        userMapper.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void orderOnline(OrderInputDTO inputDTO){
        //修改汽车状态
        Wrapper<Car> carWrapper = new EntityWrapper<>();
        carWrapper.eq("id",inputDTO.getCarId());
        Car orderCar = carMapper.selectById(inputDTO.getCarId());
        Optional.ofNullable(orderCar)
                .ifPresent(stateChange -> {
                    orderCar.setState(1);
                });
        carMapper.updateById(orderCar);
        //创建新订单
        Integer rent = orderCar.getRent();
        Order order = new Order();
        order.setUserId(inputDTO.getUserId());
        order.setCarId(inputDTO.getCarId());
        order.setStartTime(inputDTO.getStartTime());
        order.setEndTime(inputDTO.getEndTime());
        Long time = (inputDTO.getEndTime().getTime()-inputDTO.getStartTime().getTime()) / (1000 * 3600 * 24);
        order.setRentalMoney(Integer.parseInt(String.valueOf(time)) * rent);
        orderMapper.insert(order);
    }

    private void updateCarState(List<Car> carList){
        Date date = new Date();
        for(int i = 0;i < carList.size();i++){
            int carId = carList.get(i).getId();
            Wrapper<Order> orderWrapper = new EntityWrapper<>();
            orderWrapper.eq("car_id",carId);
            Date endTime = orderMapper.selectEndTime(orderWrapper);
            if(endTime.getTime() < date.getTime()){
                carList.get(i).setState(0);
                carMapper.updateById(carList.get(i));
            }
        }
    }
}
