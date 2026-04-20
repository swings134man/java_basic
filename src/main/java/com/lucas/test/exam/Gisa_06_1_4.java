package com.lucas.test.exam;

/**
 * @package : com.lucas.test.exam
 * @name : Gisa_06_1_4.java
 * @date : 2026. 4. 20. 오후 5:14
 * @author : lucaskang(swings134man)
 * @Description: 컴파일 시점에 f(object) 가 결정됨 -> 실행시 실제 인스턴스 B 의 f(object) 가 호출됨 -> 2 출력
**/
public class Gisa_06_1_4 {

    private static class A {
        String f(Object x) {
            return "1";
        }
        String g() {
            return f("a");
        }
    }

    private static class B extends A{
        String f(Object x) {
            return "2";
        }
        String f(String x) {
            return "3";
        }
    }


    public static void main(String[] args) {
        A x = new B();
        System.out.println(x.g());
    }
}
