package com.lucas.abstract_java.basic;

/************
 * @info : Car Abstract class - 상속받은 실체 클래스
 * @name : Sonata
 * @date : 2023/01/25 10:06 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Sonata extends Car{

    public static final int maxSpeed = MAX_SPEED; // 상수

    public Sonata() {
        this.name = "Sonata";
        this.speed = 100;
        super.engineStart(); // 객체 호출시, Car 클래스의 engineStart() 메서드 실행
    }

    @Override
    public void color() {
        System.out.println("White");
    }

    @Override
    public void type() {
        System.out.println("sedan");
    }

    @Override
    public void sounds() {
        System.out.println("뿌뿌!!!");
    }

    private void frame() {
        System.out.println("철강");
    }

    public void speed() {
        System.out.println(maxSpeed);
    }

    @Override
    public void stop() {
        System.out.println("sonata has stopped");
    }
}
