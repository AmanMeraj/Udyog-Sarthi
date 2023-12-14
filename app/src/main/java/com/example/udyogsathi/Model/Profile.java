package com.example.udyogsathi.Model;

import java.io.Serializable;

public class Profile implements Serializable {

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHighQualificaton() {
        return highQualificaton;
    }

    public void setHighQualificaton(String highQualificaton) {
        this.highQualificaton = highQualificaton;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String _id;
    public String name;
    public String dob;
    public String adress;
    public String phone;
    public String email;
    public String highQualificaton;
    private String aadhar;
    public  String Gender;
}
