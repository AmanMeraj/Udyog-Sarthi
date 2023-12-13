package com.example.udyogsathi.Model;

import java.io.Serializable;

public class Help implements Serializable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Help(String title, String issue, String status) {
        this.title = title;
        this.issue = issue;
        this.status = status;
    }

    public String title;
    public String issue;
    public String status;

}
