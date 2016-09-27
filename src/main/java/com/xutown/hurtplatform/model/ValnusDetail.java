package com.xutown.hurtplatform.model;

public class ValnusDetail {
    private String id;

    private String valId;

    private String location;

    private String bloodloss;

    private String remark;

    private String accId;

    private String patientId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getValId() {
        return valId;
    }

    public void setValId(String valId) {
        this.valId = valId == null ? null : valId.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getBloodloss() {
        return bloodloss;
    }

    public void setBloodloss(String bloodloss) {
        this.bloodloss = bloodloss == null ? null : bloodloss.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}