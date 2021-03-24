package com.example.cmfs1.Model;

public class MaritalStatusModel {
    private String marCode;
    private String marStatus;

    public MaritalStatusModel(String marCode, String marStatus) {
        this.marCode = marCode;
        this.marStatus = marStatus;
    }

    public String getMarCode() {
        return marCode;
    }

    public void setMarCode(String marCode) {
        this.marCode = marCode;
    }

    public String getMarStatus() {
        return marStatus;
    }

    public void setMarStatus(String marStatus) {
        this.marStatus = marStatus;
    }

    @Override
    public String toString() {
        return "MaritalStatusModel{" +
                "marCode='" + marCode + '\'' +
                ", marStatus='" + marStatus + '\'' +
                '}';
    }
}
