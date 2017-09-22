package com.example.fuelconsuption;

import android.media.Image;

/**
 * Created by werne on 2017/03/18.
 */

public class CarDetails {

    private String Name;
    private int ModelYear;
    private String fuelType;

    public CarDetails(String name, int modelYear, String fuelType) {

        Name = name;
        ModelYear = modelYear;
        this.fuelType = fuelType;
    }

    public CarDetails(String name) {
        Name = name;
    }

    public CarDetails() {

    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getModelYear() {
        return ModelYear;
    }

    public void setModelYear(int modelYear) {
        ModelYear = modelYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "Name='" + Name + '\'' +
                ", ModelYear=" + ModelYear +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
