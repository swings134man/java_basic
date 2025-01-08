package com.lucas.collections.set;


import java.util.*;

/************
 * @info : Java - Set 기본
 * @name : Set_basic
 * @date : 2023/01/31 3:00 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * - java Collection 에는 Set 이 있음.
 * 1. Set의 종류 대표 3가지 (HashSet(대표), TreeSet, LinkedHashSet
 * 2. 객체(data) 중복 저장 불가. 순서 없음.(보장X)
 *
 * - Set 컬렉션의 공통 주요 메소드 : add(추가), iterator(검색을 위한 반복자 생성), size(저장 객체 수), clear(객체 모두 삭제), remove(Object o):(해당 객체 삭제)
 *
 ************/
public class Set_basic {

    public static void main(String[] args) {
//        hash_set();
        linked_set();
//        tree_set();
    }//main

    // HashSet
    public static void hash_set() {
        /*
            - Hash Set
             1. 값(data) 는 중복 될 수 없다. (중복값 삽입 불가.)
             2. 순서가 보장되지 않는다. (순서 없음. hasCode 값에 의해 순서가 정의된다.)
         */
        Set<String> set = new HashSet<String>(); // HashSet<> hash = new HashSet<>(); 가능.
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("five"); // 중복값. 저장 되지 않음.

        System.out.println("저장 객체 수: " + set.size());
        System.out.println("-------------------------------------");

        // 반복자 - set 내부 객체 출력. -> 순서가 존재 하지 않기 때문에 get() 방식으로 가져올 수 없음.
        // Iterator 를 통해 next 로 하나씩 데이터를 출력해야 함.
        Iterator<String> iterator = set.iterator(); // Iterator, 반복자 생성.
        while (iterator.hasNext()) {             // hasNext : Data 존재시 true / false
            System.out.println(iterator.next()); // next: 다음 data return
        }
        System.out.println("-------------------------------------");

        // Data 단건 제거
        set.remove("three");
        System.out.println("저장 객체 수: " + set.size());

        boolean o = set.contains("o"); // 해당 객체가 포함되어있는지? true/false
        System.out.println(o);
        System.out.println("-------------------------------------");

        System.out.println(set); // 전체 목록 출력.
    }// Hash_set

    // LinkedHashSet
    public static void linked_set() {
        /*
            - LinkedSet
            1. 중복은 허용하지 않음.
            2. 순서가 보장됨. (add 순서대로 저장됨.)
         */
        Set<String> lSet = new LinkedHashSet<String>();
        lSet.add("one");
        lSet.add("two");
        lSet.add("three");
        lSet.add("four");
        lSet.add("five");
        lSet.add("five"); // 중복값

        System.out.println("저장 객체 수: " + lSet.size());
        System.out.println("-------------------------------------");

        Iterator<String> iterator = lSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------------------");
        lSet.remove("three");
        System.out.println("저장 객체 수: " + lSet.size());
        System.out.println("-------------------------------------");

        System.out.println(lSet);
    }// LinkedHashSet

    // TreeSet
    public static void tree_set() {
        /*
            - TreeSet
            1. 데이터를 오름차순으로 값을 정렬하여 가지고 있음.
            2. 데이터 중복 불가.
            3. 순서 보장되지 않음.
            4. 대량 Data 검색시 빠름.
         */
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(5);
        set.add(5); // 중복값.
        set.add(3);
        set.add(4);

        // Iterator 대신 Stream 사용 가능.
        set.stream().forEach(System.out::println);
        System.out.println("저장 객체 수: " + set.size());
        System.out.println("-------------------------------------");


        set.remove(1);
        System.out.println("저장 객체 수: " + set.size());
        System.out.println(set);
    }// TreeSet
}//class
