package com.lucas.interface_java.basic;

/************
 * @info : interface - 기본
 * @name : Basic_Interface
 * @date : 2023/01/25 5:06 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 *  - interface 란? -> 추상 메서드(abstract)로만 이루어진 형태, 객체의 사용 방법(설계도)을 정의한 타입.
 *    - 다중 상속 가능. (class는 다중 상속 불가.) -> interface 끼리 상속가능.
 *
 *  1. interface는 규칙을 정의 -> 추상메서드만 선언 가능! (abstract)
 *  2. interface는 인스턴스 변수를 포함할 수 없음. -> int a; ****(상수 외 필드 선언 불가.)
 *  3. interface에 선언된 모든 Method는 -> public이고 abstract이다.
 *      3-1. public과 abstract 는 생략 가능.
 *  4. 구현 Class 를 구현하여 정의된 추상메서드를 구현.
 *
 ************/
public interface Basic_Interface {

    // Field - 상수
    public static final String BASIC_RES = "BASIC";

    // Method - abstract(추상), public, abstract 키워드 생략 가능.
    public abstract void called(String param);

    void callBy(String param);

    int add(int a, int b);

    // ------ interface 잘못된 사용 예시 ------

    // 인스턴스 변수 - 가질 수 없음
    // int a;

    // Mehtod - 실행 블록(body) 를 작성 할 수 없음.
    //int calc(int a, int b) {
    //    return a+b;
    //}
}
