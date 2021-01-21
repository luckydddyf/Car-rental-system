package com.example.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.User;
import com.example.system.entity.dto.car.FrontCarItemDTO;
import com.example.system.entity.dto.user.FrontUserItemDTO;
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
public interface UserMapper extends BaseMapper<User> {
    /**
     *  mixList
     * @param ew 条件构造器
     * @param page
     * @return
     */
    @Select("select u.id id,u.account account,u.name,u.sex sex,u.age age " +
            "from t_user u " +
            "where 1 = 1 ${ew.sqlSegment}")
    List<User> mixList(@Param("ew") Wrapper<User> ew, @Param("page") Page<FrontUserItemDTO> page);
}
