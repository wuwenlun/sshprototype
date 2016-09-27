package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.VitalSign;

public interface VitalSignMapper {
    int deleteByPrimaryKey(String id);

    int insert(VitalSign record);

    int insertSelective(VitalSign record);

    VitalSign selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(VitalSign record);

    int updateByPrimaryKey(VitalSign record);
}