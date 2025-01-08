package com.lucas.interface_java.test;

public class CalcImpl implements ComplexCalc{

    int ac = AC;

    // CalcDistance
    @Override
    public double kmToMile(double km) {
        double miles = km * 0.62137;
        return miles;
    }

    @Override
    public double mileToKm(double mile) {
        double km = mile * 1.609344;
        return km;
    }

    // Calculator
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int min(int a, int b) {
        return a-b;
    }

    @Override
    public int multiple(int a, int b) {
        return a*b;
    }

    @Override
    public int division(int a, int b) {
        return a/b;
    }

    // ComplexCalc
    @Override
    public double kmAddMileConvertToKm(double km, double mile) {
        double conMile = mileToKm(mile);

        return km + conMile;
    }
}
