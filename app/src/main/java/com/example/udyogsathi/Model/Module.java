package com.example.udyogsathi.Model;

import java.io.Serializable;

public class Module implements Serializable {
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public Module(String module, int arrow) {
        this.module = module;
        this.arrow = arrow;
    }

    public  String module;
    public int arrow;
}
