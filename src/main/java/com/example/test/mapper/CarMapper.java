package com.example.test.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.test.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:38
 */
@Mapper
@Repository
public interface CarMapper extends BaseMapper<Car> {
}
