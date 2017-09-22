package com.example.fuelconsuption;

import android.media.Image;

import java.util.List;

/**
 * Created by werne on 2017/03/18.
 */

public class Family {

    private String familyName;
    private String familyPassword;
    private List<User> familyUsers;

    public Family(String familyName, String familyPassword, List<User> familyUsers) {
        this.familyName = familyName;
        this.familyPassword = familyPassword;
        this.familyUsers = familyUsers;
    }

    public Family() {

    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyPassword() {
        return familyPassword;
    }

    public void setFamilyPassword(String familyPassword) {
        this.familyPassword = familyPassword;
    }

    public List<User> getFamilyUsers() {
        return familyUsers;
    }

    public void setFamilyUsers(List<User> familyUsers) {
        this.familyUsers = familyUsers;
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", familyPassword='" + familyPassword + '\'' +
                '}';
    }
}
