package com.app.listview.model;

import java.io.Serializable;

public class Contact implements Serializable {

    public static final  long serialVersionUID = 1L;
    private String Name, Phone, Email, Website;

    public Contact(String name, String phone, String email, String website) {
        super();
        Name = name;
        Phone = phone;
        Email = email;
        Website = website;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}