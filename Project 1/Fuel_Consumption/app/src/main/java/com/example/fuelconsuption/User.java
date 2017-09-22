package com.example.fuelconsuption;

import android.media.Image;

import java.util.List;

/**
 * Created by werne on 2017/03/18.
 */

public class User extends Family {

    private String username;
    private String password;
    private String country;

    public User(String familyName, String familyPassword, List<User> familyUsers, String username, String password, String country) {
        super(familyName, familyPassword, familyUsers);
        this.username = username;
        this.password = password;
        this.country = country;
    }

    public User(String username, String password, String country) {

        this.username = username;
        this.password = password;
        this.country = country;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {

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


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return username + " " + password;
    }
}
