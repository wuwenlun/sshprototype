package com.xutown.hurtplatform.model;

public class VitalSign {
    private String id;

    private String accId;

    private String patientId;

    private String bpSbp;

    private String bpDbp;

    private String pHeartRate;

    private String spo2;

    private String breathingRate;

    private String bodyTemperature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId == null ? null : accId.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getBpSbp() {
        return bpSbp;
    }

    public void setBpSbp(String bpSbp) {
        this.bpSbp = bpSbp == null ? null : bpSbp.trim();
    }

    public String getBpDbp() {
        return bpDbp;
    }

    public void setBpDbp(String bpDbp) {
        this.bpDbp = bpDbp == null ? null : bpDbp.trim();
    }

    public String getpHeartRate() {
        return pHeartRate;
    }

    public void setpHeartRate(String pHeartRate) {
        this.pHeartRate = pHeartRate == null ? null : pHeartRate.trim();
    }

    public String getSpo2() {
        return spo2;
    }

    public void setSpo2(String spo2) {
        this.spo2 = spo2 == null ? null : spo2.trim();
    }

    public String getBreathingRate() {
        return breathingRate;
    }

    public void setBreathingRate(String breathingRate) {
        this.breathingRate = breathingRate == null ? null : breathingRate.trim();
    }

    public String getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(String bodyTemperature) {
        this.bodyTemperature = bodyTemperature == null ? null : bodyTemperature.trim();
    }
}