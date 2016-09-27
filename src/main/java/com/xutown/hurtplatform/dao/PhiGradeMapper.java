package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.PhiGrade;

public interface PhiGradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhiGrade record);

    int insertSelective(PhiGrade record);

    PhiGrade selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhiGrade record);

    int updateByPrimaryKey(PhiGrade record);
}