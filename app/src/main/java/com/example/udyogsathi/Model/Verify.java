package com.example.udyogsathi.Model;

import java.io.Serializable;

public class Verify implements Serializable {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public  String token;
    public  String userId;
}
