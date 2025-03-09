package com.lucas.test.code_test;

/**
 * @package : com.lucas.test.code_test
 * @name : GenericTypeTest.java
 * @date : 2025. 3. 9. 오후 3:42
 * @author : lucaskang(swings134man)
 * @Description: Generic Type Test
 *
 * - Java 의 OverLoading 규칙에 따라 Compile 시점에 타입이 결정된다.
 * - Container 객체 생성 시점에 값은 0=Int 지만, <Integer> 를 명시하지 않았기에
 *      Container<Object> 로 추론된다.
 * - 타입명시 하지 않으면 Raw Type 으로 추론된다.
 * - 다만, 내부 값은 Integer 로 유지하긴 하지만, Raw Type 으로 추론되어, Object 로 인식된다.
 *
 * - Raw Type: Generic Class 를 사용할떄, 타입을 명시하지 않고 사용하는 경우
 * 컴파일러에 의해 Object 로 인식(취급) 된다.
 * 실제 Type 이 존재하더라도, 컴파일러가 타입을 체크하지 않음. -> 타입 안정성 문제 발생함.
**/
public class GenericTypeTest {
    public static void main(String[] args) {
        new Container(0).print();
    }

    public static class Container<T>{
        T value;
        public Container(T t) {
            this.value = t;
        }

        public void print() {
            new Printer().print(value);
        }
    }
}

class Printer{
    void print(Integer A) {
        System.out.println("A" + A);
    }

    void print(Object B) {
        System.out.println("B" + B);
    }
}
