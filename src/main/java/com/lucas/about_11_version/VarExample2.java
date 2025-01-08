package com.lucas.about_11_version;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/************
 * @info : VarExample2
 * @name : VarExample2
 * @date : 2024. 6. 14. 오후 10:42
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Lambda 파라미터 지역변수에 var 사용
 ************/
public class VarExample2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> listParam = list.stream()
                .map((var s) -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("listParam = " + listParam);

        // -----
        new VarExample2().test();
    }

    private void test() {
        // FOR var Test
        List<String> list = List.of("a", "b", "c");
        for(var str : list) {
            System.out.println("str = " + str);
        }
    }
}
