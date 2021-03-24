package com.example.cmfs1.Model;

import java.util.Objects;

public class DistrictSpinner {
    private String DI_ST_ID_FK;
    private String DI_District;

    public DistrictSpinner(String DI_ST_ID_FK, String DI_District) {
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
        return  DI_District;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DistrictSpinner) {
            DistrictSpinner districtSpinner = (DistrictSpinner) obj;
            if (districtSpinner.getDI_District().equals(DI_District) && districtSpinner.getDI_ST_ID_FK() == DI_ST_ID_FK) return true;
        }
        return false;
    }

}
