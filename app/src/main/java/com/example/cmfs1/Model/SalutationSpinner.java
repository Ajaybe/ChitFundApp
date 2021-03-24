package com.example.cmfs1.Model;

import java.util.Objects;

public class SalutationSpinner {
    private String salCode;
    private String salutation;

    public SalutationSpinner(String salCode, String salutation) {
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
        return  salutation ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SalutationSpinner) {
            SalutationSpinner ssp = (SalutationSpinner) obj;
            if (ssp.getSalutation().equals(salutation) && ssp.getSalCode() == salCode) return true;
        }
        return false;
    }

}
