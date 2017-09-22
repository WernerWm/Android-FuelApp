package com.example.fuelconsuption;

/**
 * Created by werne on 2017/03/18.
 */

public class FillUpDetails  {

    private double fuelUsage;
    private double price;
    private String fuelStation;
    private double averageFuelConsumption;
    private double odometerReading;

    public FillUpDetails(double fuelUsage, double price, String fuelStation, double averageFuelConsumption, double odometerReading) {
        this.fuelUsage = fuelUsage;
        this.price = price;
        this.fuelStation = fuelStation;
        this.averageFuelConsumption = averageFuelConsumption;
        this.odometerReading = odometerReading;
    }

    public FillUpDetails() {

    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(double odometerReading) {
        this.odometerReading = odometerReading;
    }

    public String getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(String fuelStation) {
        this.fuelStation = fuelStation;
    }

    @Override
    public String toString() {
        return "FillUpDetails{" +
                "fuelUsage=" + fuelUsage +
                ", price=" + price +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", fuelStation='" + fuelStation + '\'' +
                '}';
    }


}
