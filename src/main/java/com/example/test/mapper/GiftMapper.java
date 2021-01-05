package com.example.test.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.test.entity.Gift;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-05 15:22
 */
@Mapper
@Repository
public interface GiftMapper extends BaseMapper<Gift> {
}
