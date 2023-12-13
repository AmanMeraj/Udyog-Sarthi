package com.example.udyogsathi.Login;

import java.io.Serializable;

public class LoginResponse implements Serializable {
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

    public  String message;
public  int status;
}
