package com.xutown.hurtplatform.model;

public class Stretcher {
    private String id;

    private Byte stretcherNo;

    private String stretcherCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getStretcherNo() {
        return stretcherNo;
    }

    public void setStretcherNo(Byte stretcherNo) {
        this.stretcherNo = stretcherNo;
    }

    public String getStretcherCode() {
        return stretcherCode;
    }

    public void setStretcherCode(String stretcherCode) {
        this.stretcherCode = stretcherCode == null ? null : stretcherCode.trim();
    }
}