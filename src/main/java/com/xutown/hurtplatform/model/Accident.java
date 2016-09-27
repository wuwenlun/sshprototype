package com.xutown.hurtplatform.model;

import java.util.Date;

public class Accident {
    private String id;

    private String patientId;

    private String deliverHospital;

    private Date receiveAlarmTime;

    private Date rescueArriveTime;

    private String temperature;

    private String humidity;

    private String weatherStatus;

    private String accidentSpot;

    private String transport;

    private String vulnusAccidentType;

    private String stretcherId;

    private String handleUser;

    private Date addTime;

    private String cureSituation;

    private String accidentRemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getDeliverHospital() {
        return deliverHospital;
    }

    public void setDeliverHospital(String deliverHospital) {
        this.deliverHospital = deliverHospital == null ? null : deliverHospital.trim();
    }

    public Date getReceiveAlarmTime() {
        return receiveAlarmTime;
    }

    public void setReceiveAlarmTime(Date receiveAlarmTime) {
        this.receiveAlarmTime = receiveAlarmTime;
    }

    public Date getRescueArriveTime() {
        return rescueArriveTime;
    }

    public void setRescueArriveTime(Date rescueArriveTime) {
        this.rescueArriveTime = rescueArriveTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void setWeatherStatus(String weatherStatus) {
        this.weatherStatus = weatherStatus == null ? null : weatherStatus.trim();
    }

    public String getAccidentSpot() {
        return accidentSpot;
    }

    public void setAccidentSpot(String accidentSpot) {
        this.accidentSpot = accidentSpot == null ? null : accidentSpot.trim();
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport == null ? null : transport.trim();
    }

    public String getVulnusAccidentType() {
        return vulnusAccidentType;
    }

    public void setVulnusAccidentType(String vulnusAccidentType) {
        this.vulnusAccidentType = vulnusAccidentType == null ? null : vulnusAccidentType.trim();
    }

    public String getStretcherId() {
        return stretcherId;
    }

    public void setStretcherId(String stretcherId) {
        this.stretcherId = stretcherId == null ? null : stretcherId.trim();
    }

    public String getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser == null ? null : handleUser.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCureSituation() {
        return cureSituation;
    }

    public void setCureSituation(String cureSituation) {
        this.cureSituation = cureSituation == null ? null : cureSituation.trim();
    }

    public String getAccidentRemark() {
        return accidentRemark;
    }

    public void setAccidentRemark(String accidentRemark) {
        this.accidentRemark = accidentRemark == null ? null : accidentRemark.trim();
    }
}