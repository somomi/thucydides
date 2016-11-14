package com.dataart.serenitybdd.models;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class User {
    private String username;
    private String password, cPassword;
    private String fname, lname;
    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCpasword() {
        return cPassword;
    }

    public void setCpassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
