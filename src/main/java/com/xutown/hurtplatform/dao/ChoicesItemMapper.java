package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.ChoicesItem;

public interface ChoicesItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChoicesItem record);

    int insertSelective(ChoicesItem record);

    ChoicesItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChoicesItem record);

    int updateByPrimaryKey(ChoicesItem record);
}