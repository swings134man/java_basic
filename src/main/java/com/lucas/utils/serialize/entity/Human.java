package com.lucas.utils.serialize.entity;

import java.io.Serializable;

/************
 * @info : Java Serialize
 * @name : Human
 * @date : 2023/07/06 9:19 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : java 직렬화 클래스.
 *
 * - serialVersionUID : 직렬화를 할 때 사용한다.
 *      -> Version 관리의 용도로 사용한다.
 *      -> 해당 Class 에 변경이 있을 때 버전관리의 용도로 사용한다.
 *      -> 버전이 다르다면 직렬화가 이루어지지 않는다.
 *      -> EX) Out: ver=1 -> this: ver=2 -> 직렬화 X
 ************/
public class Human implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Human() {
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // get, set, toString
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
