package com.example.udyogsathi.Model;

import java.io.Serializable;

public class Module implements Serializable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Link getOther() {
        return other;
    }

    public void setOther(Link other) {
        this.other = other;
    }

    public String title;
    public String desc;
    public Link other;
}
