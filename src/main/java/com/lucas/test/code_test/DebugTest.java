package com.lucas.test.code_test;

/************
 * @info : Debug Test
 * @name : DebugTest
 * @date : 2023/11/01 12:48 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class DebugTest {
    public static void main(String[] args) {
        DebugTest dt = new DebugTest();
        int a = 1;
        int b = 2;
        int c = 3;

        // 1. adds
        int addRes = dt.add(a, b);

        // 2. evaluate - addRes 의 값을 변경 한다면 ?
        int res = c + addRes;
        System.out.println(res);

    }


    public int add(int a, int b) {
        int res = 0;
        res = a + b;
        return res;
    }

}
