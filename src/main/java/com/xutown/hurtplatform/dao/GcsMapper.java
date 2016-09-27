package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.Gcs;

public interface GcsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Gcs record);

    int insertSelective(Gcs record);

    Gcs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Gcs record);

    int updateByPrimaryKey(Gcs record);
}