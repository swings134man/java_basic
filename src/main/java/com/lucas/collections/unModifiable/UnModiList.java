package com.lucas.collections.unModifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @package : com.lucas.collections.unModifiable
 * @name : UnModiList.java
 * @date : 2025. 3. 7. 오후 4:44
 * @author : lucaskang(swings134man)
 * @Description: Java 의 Unmodifiable 객체의 List
 *
 * Collection Framework 에서 Unmodifiable 객체는 수정이 불가능한 객체를 의미한다. -> set, remove, add 등 객체 내부의 데이터 수정 불가능
 * -> 수정 시도시 Exception 발생!
 * -> List, Map, Set 과 같은 Collection 객체를 Unmodifiable 로 만들 수 있다.
 *
 * - 주의점으로는 원본객체의 수정은 가능하기에, 원본 객체의 Deep Copy 를 수행해야 한다 -> 원본객체 변경시 Unmodifiable 객체도 변경된다.
 * --> 같은 메모리 주소를 바라보고 있기 떄문임.
 *
 * - 이러한 특성때문에 Unmodifiable 객체는 완벽한 Immutable 객체가 아니다.
**/
public class UnModiList {
    public static void main(String[] args) {
        // 1. Unmodifiable List
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> unModiList = Collections.unmodifiableList(list);

        // 2. 수정 불가능한 객체이기에, 수정 시도시 Exception 발생
        try {
            unModiList.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Unmodifiable List 수정 불가능");
        }

        // 3. 원본 객체의 수정은 가능하기에, 원본 객체의 Deep Copy 를 수행해야 한다.
        list.add("D");
        System.out.println("원본 객체 수정: " + list);
        System.out.println("Unmodifiable 객체 수정: " + unModiList);

        // 4. Deep Copy 사용
        System.out.println("----------------- Deep Copy -----------------");
        List<String> unModi2 = Collections.unmodifiableList(new ArrayList<>(list));
        List<String> unModi3 = list.stream().collect(Collectors.toUnmodifiableList());
        // Java 16^
        List<String> unModi4 = list.stream().toList(); //toList() 가 Unmodifiable 객체를 반환한다.
        System.out.println(unModi4 instanceof List);
        System.out.println(unModi4.getClass().getName());

    }
}
