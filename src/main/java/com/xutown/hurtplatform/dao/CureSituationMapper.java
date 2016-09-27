package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.CureSituation;

public interface CureSituationMapper {
    int deleteByPrimaryKey(String id);

    int insert(CureSituation record);

    int insertSelective(CureSituation record);

    CureSituation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CureSituation record);

    int updateByPrimaryKey(CureSituation record);
}