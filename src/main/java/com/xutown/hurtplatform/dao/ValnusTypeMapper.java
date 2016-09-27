package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.ValnusType;

public interface ValnusTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ValnusType record);

    int insertSelective(ValnusType record);

    ValnusType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ValnusType record);

    int updateByPrimaryKey(ValnusType record);
}