package com.lucas.etc;

import java.util.*;

/************
 * @info : Java 자료구조 clear()
 * @name : EachDataStructClear
 * @date : 2024. 6. 6. 오후 11:03
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java 의 자료구조들에서는 clear() 메서드를 통해 모든 요소를 제거할 수 있다.
 * 해당 방법은 다양한 자료구조에서 사용이 가능하다.
 * 하지만, 다른곳에서 참조하고 있는 경우에는 해당 참조가 남아있을 수 있으므로 주의해야한다.
 *
 * GC 에 의해서 메모리에서 완전 제거 되게 하려면
 * 해당 자료구조를 참조하는 변수를 null 로 초기화 해주어야 한다.
 * ---> list = null;
 ************/
public class EachDataStructClear {
    public static void main(String[] args) {
        // ArrayList
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println("Before ArrayList clear: " + list.size());
        list.clear();
        System.out.println("After ArrayList clear: " + list.size());

        // Map
        Map<String, Object> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("Before Map clear: " + map.size());
        map.clear();
        System.out.println("After Map clear: " + map.size());
    }
}
