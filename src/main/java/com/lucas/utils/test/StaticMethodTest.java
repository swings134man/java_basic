package com.lucas.utils.test;

/**
 * @package : com.lucas.utils.test
 * @name : StaticMethodTest.java
 * @date : 2025. 7. 22. 오전 1:07
 * @author : lucaskang(swings134man)
 * @Description: static method 와 local variable 테스트
 * - 기본형 변수는 Parameter 로 전달될때 값만 전달됨(주소 전달 X)
 * - 즉 + 1 은 increase 메서드 내부값만 변경.
 * -> main 의 a 변수는 여전히 10
 * - a 가 변경되려면 increase 메서드가 a 의 주소를 받아야 함 ->
 * 1. a 를 래퍼 클래스로 변경하거나, 2. 반환값을 다시 할당 받아야 함 -> a = increase(a); increase {return a + 1;}
**/
public class StaticMethodTest {
    public static void main(String[] args) {
        int a;
        a = 10;
        increase(a);
        System.out.println(a);
    }


    static public void increase(int a) {
        a = a + 1;
    }
}
