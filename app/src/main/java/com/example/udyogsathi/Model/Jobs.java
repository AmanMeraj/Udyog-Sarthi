package com.example.udyogsathi.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Jobs implements Serializable {
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEmployeNeed() {
        return employeNeed;
    }

    public void setEmployeNeed(String employeNeed) {
        this.employeNeed = employeNeed;
    }

    public ArrayList<String> getEmployeType() {
        return employeType;
    }

    public void setEmployeType(ArrayList<String> employeType) {
        this.employeType = employeType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String _id;
    public String title;
    public String desc;
    public String companyId;
    public String employeNeed;
    public ArrayList<String> employeType;
    public String salary;
    public String courseId;
    public String imageURL;
    public int __v;
}
