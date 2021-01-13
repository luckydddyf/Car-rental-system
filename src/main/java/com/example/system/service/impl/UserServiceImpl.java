package com.example.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.User;
import com.example.system.entity.dto.car.FrontCarItemDTO;
import com.example.system.entity.dto.gift.FrontGiftItemDTO;
import com.example.system.entity.dto.gift.FrontGiftPageOutputDTO;
import com.example.system.entity.dto.gift.GiftPageInputDTO;
import com.example.system.entity.dto.user.UserInputDTO;
import com.example.system.entity.dto.user.UserSelfAlertDTO;
import com.example.system.entity.dto.car.CarPageInputDTO;
import com.example.system.entity.dto.car.FrontCarPageOutputDTO;
import com.example.system.mapper.UserMapper;
import com.example.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void alertUserSelf(UserSelfAlertDTO alertDTO){
        User user = userMapper.selectById(alertDTO.getId());
        user.setPassword(alertDTO.getPassword());
        user.setName(alertDTO.getName());
        user.setSex(alertDTO.getSex());
        user.setAge(alertDTO.getAge());
        userMapper.updateById(user);
    }

    @Override
    public void orderOnline(Integer carId){


    }
}
