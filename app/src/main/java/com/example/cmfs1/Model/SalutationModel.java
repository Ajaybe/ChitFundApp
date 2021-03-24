package com.example.cmfs1.Model;

public class SalutationModel {
    private String salCode;
    private String salutation;

    public SalutationModel(String salCode, String salutation) {
        this.salCode = salCode;
        this.salutation = salutation;
    }

    public String getSalCode() {
        return salCode;
    }

    public void setSalCode(String salCode) {
        this.salCode = salCode;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return "SalutationModel{" +
                "salCode='" + salCode + '\'' +
                ", salutation='" + salutation + '\'' +
                '}';
    }
}
