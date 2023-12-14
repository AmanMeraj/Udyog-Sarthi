package com.example.udyogsathi.Profile;

import com.example.udyogsathi.Model.Profile;

import java.io.Serializable;

public class ProfileResponse implements Serializable {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Profile getData() {
        return data;
    }

    public void setData(Profile data) {
        this.data = data;
    }

    public  int status;
    public Profile data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;
}
