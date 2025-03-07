package com.lucas.collections.unModifiable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @package : com.lucas.collections.unModifiable
 * @name : UnModiMap.java
 * @date : 2025. 3. 7. 오후 5:10
 * @author : lucaskang(swings134man)
 * @Description: Java 의 Unmodifiable 객체의 Map
 *
 * - 내용은 UnModiList.java 와 동일하다.
**/
public class UnModiMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");

        // 1. Unmodifiable Map
        Map<String, String> unModiMap = Collections.unmodifiableMap(Map.copyOf(map));
//        unModiMap.put("C", "3");

        map.put("C", "3");

        System.out.println(unModiMap.get("C") == null ? "null" : unModiMap.get("C")); //null
    }
}
