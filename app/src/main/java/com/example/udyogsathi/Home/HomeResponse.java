package com.example.udyogsathi.Home;

import com.example.udyogsathi.Model.Home;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeResponse implements Serializable {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Home> getData() {
        return data;
    }

    public void setData(ArrayList<Home> data) {
        this.data = data;
    }

    public int status;
    public ArrayList<Home>data;
}
