package com.lucas.stream;

import java.util.List;

public class ToListTest {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E");
        List<String> list1 = list.stream().toList();
        System.out.println(list1 == list); //false
    }
}
