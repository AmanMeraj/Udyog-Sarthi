package com.example.udyogsathi.Register;

import java.io.Serializable;

public class RegisterResponse implements Serializable {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String message;
    public  int status;
}
