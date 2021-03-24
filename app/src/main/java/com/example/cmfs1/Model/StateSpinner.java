package com.example.cmfs1.Model;

import java.util.Objects;

public class StateSpinner {
    private String St_Id;
    private String ST_StateID;
    private String ST_StateName;

    public StateSpinner(String st_Id, String ST_StateID, String ST_StateName) {
        St_Id = st_Id;
        this.ST_StateID = ST_StateID;
        this.ST_StateName = ST_StateName;
    }

    public String getSt_Id() {
        return St_Id;
    }

    public void setSt_Id(String st_Id) {
        St_Id = st_Id;
    }

    public String getST_StateID() {
        return ST_StateID;
    }

    public void setST_StateID(String ST_StateID) {
        this.ST_StateID = ST_StateID;
    }

    public String getST_StateName() {
        return ST_StateName;
    }

    public void setST_StateName(String ST_StateName) {
        this.ST_StateName = ST_StateName;
    }

    @Override
    public String toString() {
        return  ST_StateName ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StateSpinner) {
            StateSpinner stateSpinner = (StateSpinner) obj;
            if (stateSpinner.getST_StateName().equals(ST_StateName) && stateSpinner.getSt_Id().equals(ST_StateID) &&
            stateSpinner.getSt_Id().equals(St_Id)) return true;
        }
        return false;
    }

}
