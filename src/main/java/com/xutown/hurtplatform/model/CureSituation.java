package com.xutown.hurtplatform.model;

public class CureSituation {
    private String id;

    private String patientId;

    private String accId;

    private String choiceItemId;

    private String itemRemark;

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

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId == null ? null : accId.trim();
    }

    public String getChoiceItemId() {
        return choiceItemId;
    }

    public void setChoiceItemId(String choiceItemId) {
        this.choiceItemId = choiceItemId == null ? null : choiceItemId.trim();
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark == null ? null : itemRemark.trim();
    }
}