package com.example.himanshu.studydeforis;

/**
 * Created by Himanshu on 12-10-2016.
 */
public class Contacts {
    private String name , email , username , password;

    public Contacts(String name , String email , String username , String password) {
        this.setName(name);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
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



}
