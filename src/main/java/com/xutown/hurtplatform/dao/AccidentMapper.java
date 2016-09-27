package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.Accident;

public interface AccidentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Accident record);

    int insertSelective(Accident record);

    Accident selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Accident record);

    int updateByPrimaryKey(Accident record);
}