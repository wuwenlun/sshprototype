package com.xutown.hurtplatform.model;

import java.util.Date;

public class PhiGrade {
    private String id;

    private String mentalStatus;

    private String attachValnusStatus;

    private String bspScope;

    private String heartRateScope;

    private String breatheRateScope;

    private String patientId;

    private String accId;

    private Date addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMentalStatus() {
        return mentalStatus;
    }

    public void setMentalStatus(String mentalStatus) {
        this.mentalStatus = mentalStatus == null ? null : mentalStatus.trim();
    }

    public String getAttachValnusStatus() {
        return attachValnusStatus;
    }

    public void setAttachValnusStatus(String attachValnusStatus) {
        this.attachValnusStatus = attachValnusStatus == null ? null : attachValnusStatus.trim();
    }

    public String getBspScope() {
        return bspScope;
    }

    public void setBspScope(String bspScope) {
        this.bspScope = bspScope == null ? null : bspScope.trim();
    }

    public String getHeartRateScope() {
        return heartRateScope;
    }

    public void setHeartRateScope(String heartRateScope) {
        this.heartRateScope = heartRateScope == null ? null : heartRateScope.trim();
    }

    public String getBreatheRateScope() {
        return breatheRateScope;
    }

    public void setBreatheRateScope(String breatheRateScope) {
        this.breatheRateScope = breatheRateScope == null ? null : breatheRateScope.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId == null ? null : accId.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}