package test.code_test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFindTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "dcdc", "asdc");

        Stream<String> c = list.stream().filter(item -> item.contains("c"));

        // list 의 특정 키워드가 포함된 데이터를 찾아서, 해당 데이터를 스트링으로 반환
        System.out.println("c = " + c.collect(Collectors.joining(", ", "[", "]")));

    }
}
