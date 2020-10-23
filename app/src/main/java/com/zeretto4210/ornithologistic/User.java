package com.zeretto4210.ornithologistic;

public class User{
    String name, lastname, gender, date;

    public User() {
        this.name = "NO";
        this.lastname = "NO";
        this.gender = "NO";
        this.date = "NO";
    }
    public User(String name, String lastname, String gender, String date) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getgender() {
        return gender;
    }

    public void setSex(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
