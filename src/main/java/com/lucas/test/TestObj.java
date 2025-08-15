package com.lucas.test;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @package : com.lucas.test
 * @name : TestObj.java
 * @date : 2025. 8. 15. 오후 5:28
 * @author : lucaskang(swings134man)
 * @Description: 객체 불변성 테스트
**/
public class TestObj {
    public static void main(String[] args) {
        Cat one = new Cat("Jerry", 8); // save 대상
        Cat two = new Cat("bom", 5);

        // test
        // .... 중간에 잘못된 로직으로 one 객체의 값이 변경됨 -> 잘못된 정보 저장
        System.out.println("basic code" +  one);

        // 깊은 복사
        Cat oneCopy = new Cat(one.getName(), one.getAge());
        System.out.println("deep copy code: " + oneCopy);

    }


    // 객체
    @Getter @Setter
    private static class Cat {
        private String name;
        private int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cat)) return false;

            Cat cat = (Cat) o;

            if (age != cat.age) return false;
            return name != null ? name.equals(cat.name) : cat.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }
}

