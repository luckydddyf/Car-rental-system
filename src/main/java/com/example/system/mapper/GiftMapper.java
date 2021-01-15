package com.example.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.system.entity.Car;
import com.example.system.entity.Gift;
import com.example.system.entity.dto.car.FrontCarItemDTO;
import com.example.system.entity.dto.gift.FrontGiftItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 15:22
 */
@Mapper
@Repository
public interface GiftMapper extends BaseMapper<Gift> {
    /**
     *  mixList
     * @param ew 条件构造器
     * @param page
     * @return
     */
    @Select("select g.id id,g.name name,g.desc desc,g.start_time startTime,g.end_time endTime " +
            "from t_gift g " +
            "where 1 = 1 ${ew.sqlSegment}")
    List<Gift> mixList(@Param("ew") Wrapper<Gift> ew, @Param("page") Page<FrontGiftItemDTO> page);
}
