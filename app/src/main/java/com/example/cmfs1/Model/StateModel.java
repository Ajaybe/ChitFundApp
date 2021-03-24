package com.example.cmfs1.Model;

public class StateModel {
    private String St_Id;
    private String ST_StateID;
    private String ST_StateName;

    public StateModel(String st_Id, String ST_StateID, String ST_StateName) {
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
        return "StateModel{" +
                "St_Id='" + St_Id + '\'' +
                ", ST_StateID='" + ST_StateID + '\'' +
                ", ST_StateName='" + ST_StateName + '\'' +
                '}';
    }
}
