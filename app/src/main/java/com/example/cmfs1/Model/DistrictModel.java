package com.example.cmfs1.Model;

public class DistrictModel {
    private String DI_ST_ID_FK;
    private String DI_District;

    public DistrictModel(String DI_ST_ID_FK, String DI_District) {
        this.DI_ST_ID_FK = DI_ST_ID_FK;
        this.DI_District = DI_District;
    }

    public String getDI_ST_ID_FK() {
        return DI_ST_ID_FK;
    }

    public void setDI_ST_ID_FK(String DI_ST_ID_FK) {
        this.DI_ST_ID_FK = DI_ST_ID_FK;
    }

    public String getDI_District() {
        return DI_District;
    }

    public void setDI_District(String DI_District) {
        this.DI_District = DI_District;
    }

    @Override
    public String toString() {
        return "DistrictModel{" +
                "DI_ST_ID_FK='" + DI_ST_ID_FK + '\'' +
                ", DI_District='" + DI_District + '\'' +
                '}';
    }
}
