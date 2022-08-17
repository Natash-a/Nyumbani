package com.example.nyumbani;

public class userinfo {
    private String name,email,contact,username,password,housenumber;

    public userinfo() {
    }

    public userinfo(String name, String email, String contact, String username, String password, String housenumber) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.housenumber = housenumber;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }
}
