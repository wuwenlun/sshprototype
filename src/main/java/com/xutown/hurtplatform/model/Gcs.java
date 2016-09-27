package com.xutown.hurtplatform.model;

public class Gcs {
    private String id;

    private String accId;

    private String patientId;

    private String eyeOpenStatus;

    private String verbalStatus;

    private String actionStatus;

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

    public String getEyeOpenStatus() {
        return eyeOpenStatus;
    }

    public void setEyeOpenStatus(String eyeOpenStatus) {
        this.eyeOpenStatus = eyeOpenStatus == null ? null : eyeOpenStatus.trim();
    }

    public String getVerbalStatus() {
        return verbalStatus;
    }

    public void setVerbalStatus(String verbalStatus) {
        this.verbalStatus = verbalStatus == null ? null : verbalStatus.trim();
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus == null ? null : actionStatus.trim();
    }
}