package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.ChoiceAttr;

public interface ChoiceAttrMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChoiceAttr record);

    int insertSelective(ChoiceAttr record);

    ChoiceAttr selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChoiceAttr record);

    int updateByPrimaryKey(ChoiceAttr record);
}