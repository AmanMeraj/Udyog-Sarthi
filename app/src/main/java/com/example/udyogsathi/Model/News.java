package com.example.udyogsathi.Model;

import java.io.Serializable;

public class News implements Serializable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public News(String title, String description, String time, int image) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.image = image;
    }

    public  String title;
    public  String description;
    public  String time;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public  int image;
}
