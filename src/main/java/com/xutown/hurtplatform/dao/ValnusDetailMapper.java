package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.ValnusDetail;

public interface ValnusDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(ValnusDetail record);

    int insertSelective(ValnusDetail record);

    ValnusDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ValnusDetail record);

    int updateByPrimaryKey(ValnusDetail record);
}