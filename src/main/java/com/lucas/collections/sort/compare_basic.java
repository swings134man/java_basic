package com.lucas.collections.sort;

import lombok.ToString;

import java.util.*;

/**
 * @package : com.lucas.collections.sort
 * @name : compare_basic.java
 * @date : 2025. 2. 12. 오후 12:44
 * @author : lucaskang(swings134man)
 * @Description: Java Compare 기본
 * - Java 의 Comparator 는 기본적인 정렬 기능을 지원한다 -> Collections.sort(target)
 *
 * - Comparator 를 사용하면 기본적인 정렬 기능을 커스터마이징 할 수 있다. -> 2개의 매개변수를 객체 비교한다.
 *      - 별도의 정렬 기준을 만들고 싶을때 사용하는 인터페이스.
 *      - compare(T o1, T o2) 메소드를 구현해야 한다.
 *
 * - Comparable 은 기본 정렬 기능을 제공한다. -> 이는 Interface 이다. -> 자기 자신과 다른 매개변수 객체를 비교한다.
 *      - 객체 자체에 정렬 기준을 정의하는 인터페이스
 *      - interface 이기 때문에 직접 구현해야 한다.
 *      - compareTo(O o) 메소드를 구현해야 한다.
 *      - Collections.sort(List<T>) 같은 메서드에 자동적용됨
 *
 * - 기본적으로 두개의 객체를 비교할때 사용되는 방법은 아래와 같음 (str1, str2)
 *      -> str1.compareTo(str2) : str1 이 str2 보다 작으면 음수, 같으면 0, 크면 양수를 반환한다.
 *      -> 즉 음수가 나오면 str1 이 앞으로, 양수가 나오면 str2 가 앞으로 정렬된다.
 *      -> 이는 Comparator, Comparable 구현시 동일한 규칙이다.
 *      --> 이는 오름차순의 경우이고
 *      --> 내림차순의 경우에는 반대로 해주면 된다.
 *      --> str2.compareTo(str1) : str2 가 str1 보다 작으면 음수, 같으면 0, 크면 양수를 반환한다. -> 양수가 앞으로 정렬
 *
 * - 일반적으로 한번 사용하고 버릴때 Comparator 를 사용하고, 계속 사용할때 Comparable 을 사용한다.
 * -> 특히나 Comparator 의 경우 익명클래스로 사용하는 경우가 많고 좋음 -> 사용 후 Stack 에서 제거됨.
 *
 * - 요약: Comparable 은 객체의 기본 정렬정의, Comparator 는 여러 정렬 방식이 필요할 때 사용됨
**/
public class compare_basic {
    // 비교 대상 객체
    @ToString
    static class Dog {
        String name;
        int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // ------------------------ Main ------------------------
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        List<DogComparable> dogsComparable = new ArrayList<>();

        Dog dog1 = new Dog("A", 2);
        Dog dog2 = new Dog("B", 5);
        Dog dog11 = new Dog("AA", 1);

        System.out.println(" ------------------------ Comparator Class ------------------------ ");
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog11);
        Collections.sort(dogs, new DogComparator()); // Comparator Class 사용
        System.out.println("Comparator Class - 정렬 -> " + dogs);


        System.out.println();
        System.out.println(" ------------------------ Comparator Anonymous Class ------------------------ ");
        // Comparator 익명 클래스 - 나이 순으로만 정렬(오름차순)
        Collections.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });

        System.out.println("Comparator 익명 클래스 - 정렬 -> " + dogs);



        System.out.println();
        System.out.println(" ------------------------ Comparable Class ------------------------ ");
        // Comparator Class
        DogComparable dog3 = new DogComparable("A", 2);
        DogComparable dog4 = new DogComparable("B", 5);
        DogComparable dog5 = new DogComparable("C", 1);

        dogsComparable.add(dog3);
        dogsComparable.add(dog4);
        dogsComparable.add(dog5);

        int compared = dog4.compareTo(dog3);
        System.out.println("Comparable Class - compareTo -> " + compared);

        // 정렬
        Collections.sort(dogsComparable);

        System.out.println("Comparable Class - 정렬 -> " + dogsComparable);

    }

    // ------------------------ Impl Class ------------------------

    // Comparable 구현 Class -> Dog 객체를 비교함.
    // 나이 순으로 비교함
    @ToString
    static class DogComparable implements Comparable<DogComparable> {
        String name;
        int age;

        public DogComparable(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(DogComparable o) {
            // 나이 순으로 비교 -> 양수가 나오면 앞으로, 음수가 나오면 뒤로(내림차순)
            // 빼는 대상의 순서를 바꿔줌
            return o.age - this.age;
            // return this.age - o.age; // 오름차순 (나이 적은게 빠른 순 정렬)
        }
    }

    // Comparator 구현 Class -> Dog 객체 이름, 나이 순으로 비교함
    static class DogComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog o1, Dog o2) {
            // 이름 알파벳 순서 비교 오름차순
            int name = o1.name.compareTo(o2.name);

            if(name != 0) { //같지 않으면
                return name;
            }

            return Integer.compare(o1.age, o2.age);
        }
    }

}
