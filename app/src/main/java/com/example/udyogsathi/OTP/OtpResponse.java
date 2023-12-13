package com.example.udyogsathi.OTP;

import com.example.udyogsathi.Model.Verify;

import java.io.Serializable;

public class OtpResponse implements Serializable {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int status;
public String message;

    public Verify getData() {
        return data;
    }

    public void setData(Verify data) {
        this.data = data;
    }

    public Verify data;
}
