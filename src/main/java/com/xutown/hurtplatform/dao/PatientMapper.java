package com.xutown.hurtplatform.dao;

import com.xutown.hurtplatform.model.Patient;

public interface PatientMapper {
    int deleteByPrimaryKey(String id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}