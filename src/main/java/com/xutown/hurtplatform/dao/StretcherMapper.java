package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.Stretcher;

public interface StretcherMapper {
    int deleteByPrimaryKey(String id);

    int insert(Stretcher record);

    int insertSelective(Stretcher record);

    Stretcher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Stretcher record);

    int updateByPrimaryKey(Stretcher record);
}