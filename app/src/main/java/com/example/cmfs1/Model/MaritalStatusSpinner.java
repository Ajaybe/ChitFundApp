package com.example.cmfs1.Model;

import java.util.Objects;

public class MaritalStatusSpinner {
    private String marCode;
    private String marStatus;

    public MaritalStatusSpinner(String marCode, String marStatus) {
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
        return  marStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MaritalStatusSpinner) {
            MaritalStatusSpinner mssp = (MaritalStatusSpinner) obj;
            if (mssp.getMarStatus().equals(marStatus) && mssp.getMarCode() == marCode) return true;
        }
        return false;
    }

}
