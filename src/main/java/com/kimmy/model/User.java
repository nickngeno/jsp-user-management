package com.kimmy.model;


public class User {
    private int id;
    private String name;
    private String email;
    private String country;
    private String state;
    private String city;
    private String houseNumber;
    private String phoneNumber;
    private String password;

    public User() {
    }

    public User(int id, String name, String email, String country, String state, String city, String houseNumber, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.state = state;
        this.city = city;
        this.houseNumber = houseNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

