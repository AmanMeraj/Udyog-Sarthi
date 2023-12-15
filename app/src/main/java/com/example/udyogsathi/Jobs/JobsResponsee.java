package com.example.udyogsathi.Jobs;

import com.example.udyogsathi.Model.Jobs;

import java.io.Serializable;
import java.util.ArrayList;

public class JobsResponsee implements Serializable {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Jobs> getData() {
        return data;
    }

    public void setData(ArrayList<Jobs> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  int status;
    public ArrayList<Jobs>data;
    public String message;
}
