package com.lucas.functional.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/************
 * @info : Funtional_test Class
 * @name : Functional_test3
 * @date : 2023/11/02 12:43 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : param(List)을 넘겨서 -> Car 객체로 받기?
 ************/
public class Functional_test3 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Hyundai", "Benz", "BMW");

        // send
        MakeCar mc = (list1) -> {
            List<Car> carList = new ArrayList<>();
            for (Object res : list1) {
                Car car = new Car();
                car.setName((String)res);

                carList.add(car);
            }
            return carList;
        };

        // receive
        List<Car> carList = mc.make(list);
        for (Car car: carList) {
            System.out.println("car = " + car.getName());
        }
    }

    @FunctionalInterface
    interface MakeCar {
        List<Car> make(List list);
    }
}//class


class Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
