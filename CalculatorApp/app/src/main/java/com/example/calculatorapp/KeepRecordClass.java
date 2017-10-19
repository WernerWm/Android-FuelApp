package com.example.calculatorapp;

import java.io.Serializable;
import java.util.List;

public class KeepRecordClass implements Serializable {

    private String calculations;

    public KeepRecordClass(String calculations) {
        this.calculations = calculations;
    }

    public KeepRecordClass() {

    }

    public String getCalculations() {
        return calculations;
    }

    public void setCalculations(String calculations) {
        this.calculations = calculations;
    }

    @Override
    public String toString() {
        return " " + this.calculations + " ";
    }
}
