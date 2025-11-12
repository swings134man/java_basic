package com.lucas.design_pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @package : com.lucas.design_pattern
 * @name : Prototype_1.java
 * @date : 2025. 11. 12. 오후 4:39
 * @author : lucaskang(swings134man)
 * @Description: Java Prototype Pattern 기본
 *
 * Cloneable 인터페이스를 구현하여 객체 복제를 지원 -> 얕은 복사(shallow copy) 수행 (깊은복사X)
 * -> Cloneable 인터페이스는 Protected
 *
 * 이미 생성된 객체를 복제하여 새로운 객체를 만드는 패턴
 * - 객체 생성 비용이 큰 경우 유용
**/
public class Prototype_1 {

    // prototype 대상 객체
    @ToString @Getter @Setter
    public static class Person implements Cloneable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Clone method
        @Override
        public Person clone() {
            try {
                return (Person) super.clone(); // shallow copy
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }


    public static void main(String[] args) {
        Person original = new Person("Alice", 30);
        Person copy = original.clone();
        copy.setName("Bob");
        copy.setAge(10);

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);

        System.out.println(original == copy); // false
        System.out.println(original.equals(copy)); // false
    }
}
