package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.Authorization;

public interface AuthorizationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Authorization record);

    int insertSelective(Authorization record);

    Authorization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Authorization record);

    int updateByPrimaryKey(Authorization record);
}