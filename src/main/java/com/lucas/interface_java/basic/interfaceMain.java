package com.lucas.interface_java.basic;

/************
 * @info : interface - 사용
 * @name : interfaceMain
 * @date : 2023/01/25 5:43 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class interfaceMain {

    public static void main(String[] args) {
        String param = "hi";
        int a = 1;
        int b = 2;

        // impl - 구현 class
        BasicInterfaceImpl impl = new BasicInterfaceImpl();
        impl.called(param); // override
        impl.callBy(param); // override
        impl.field(); // 상수 값.
        System.out.println(impl.basic); // 구현 클래스에서 인스턴스 변수 선언 후 상수 대입.


        System.out.println("---------------");
        // interface - 대입
        // 기존의 interface를 선언 후 impl(구현체)를 대입하여 사용 가능하다.
        Basic_Interface basicInterface;
        basicInterface = impl; //대입
        int addRes = basicInterface.add(a, b); // Override 메서드의 기능 사용.

        System.out.println(addRes);
    }
}
