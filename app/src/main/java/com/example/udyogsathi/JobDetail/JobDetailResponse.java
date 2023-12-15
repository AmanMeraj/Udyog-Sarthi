package com.example.udyogsathi.JobDetail;

import com.example.udyogsathi.Model.JobDetails;

import java.io.Serializable;

public class JobDetailResponse implements Serializable {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JobDetails getData() {
        return data;
    }

    public void setData(JobDetails data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int status;
    public JobDetails data;
    public String message;
}
