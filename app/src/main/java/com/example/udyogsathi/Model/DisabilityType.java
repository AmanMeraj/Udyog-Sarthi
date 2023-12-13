package com.example.udyogsathi.Model;

import java.io.Serializable;

public class DisabilityType implements Serializable {
    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public DisabilityType(String disability) {
        this.disability = disability;
    }

    public String disability;
}
