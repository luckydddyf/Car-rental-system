package com.example.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.dto.car.FrontCarItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:38
 */
@Mapper
@Repository
public interface CarMapper extends BaseMapper<Car> {
    /**
     *  mixList
     * @param ew 条件构造器
     * @param page
     * @return
     */
    @Select("select c.id id,c.name name,c.photo_url photoUrl,c.rent rent,c.state state " +
            "from t_car c " +
            "where 1 = 1 ${ew.sqlSegment}")
    List<Car> mixList(@Param("ew") Wrapper<Car> ew, @Param("page") Page<FrontCarItemDTO> page);

}
