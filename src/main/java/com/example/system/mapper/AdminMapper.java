package com.example.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.system.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-04 14:38
 */
@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
}
