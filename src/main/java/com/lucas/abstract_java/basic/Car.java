package com.lucas.abstract_java.basic;


/************
 * @info : Abstract - Car (최상위)
 * @name : Car
 * @date : 2023/01/25 10:03 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * - Abstract Class - 추상클래스란, 하나 이상의 추상메서드를 포함하거나, 클레스에 abstract 키워드가 붙은 클래스.
 * - interface 와 다른점.
 *   -> 생성자, private 메서드, 인스턴스 변수를 가질 수 있다.
 *
 *
 * 1. 각 클래스간 비슷한 필드, Method를 공통으로 추출해 만들어진 클래스.
 * 2. 추상클래스는 객체 생성 불가 -> 실체성이 없고 구체적이지 않기 때문.
 * 3. 추상클래스 단독 객체 생성 불가 -> 반드시 추상클래스를 상속한 실제 클래스를 통해서만 객체 생성 가능.
 * 4. 추상클래스에서 상수는 명시적으로 static 적어주어야 함. -> final 이 명시된 상수는 -> class 내부에서만 사용가능.
 *
 ************/
public abstract class Car {

    public String name;

    int speed;// 인스턴스 변수
    static final int MAX_SPEED = 120; // 상수

    public void engineStart() {
        System.out.println("부릉부릉");
    }

    public void ride() {
        System.out.println("Ride");
    }

    public void stop() {
        System.out.println("stop");
    }


    // 추상메서드
    public abstract void color(); // 구체적인 구현부 존재X

    public abstract void type(); // suv, sedan?

    public abstract void sounds();

    // private - Class 내부에서만 사용가능. 다른클래스에서 호출 불가.
    private void frame() {
        System.out.println("frame은 모두 철강.");
    }
}
