package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.GreenWay;

public interface GreenWayMapper {
    int deleteByPrimaryKey(String id);

    int insert(GreenWay record);

    int insertSelective(GreenWay record);

    GreenWay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GreenWay record);

    int updateByPrimaryKey(GreenWay record);
}