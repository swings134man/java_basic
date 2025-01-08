package com.lucas.test.code_test;

/************
 * @info : CompareToIgnoreCase Test
 * @name : CompareToTest
 * @date : 2023/07/05 9:36 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class CompareToTest {
    public static void main(String[] args) {
        String target = "AbC";

        int res1 = target.compareToIgnoreCase("abc"); // Lower, Upper Case를 신경쓰지 않고 해당 단어가 존재하면 return 0
        System.out.println("res1 = " + res1); // 0

        int res2 = target.compareToIgnoreCase("fgh"); // 존재하지 않으면 -> 음수 반환
        System.out.println("res2 = " + res2);

        int res3 = target.compareToIgnoreCase("Ab"); // 타겟보다 파라미터의 길이가 작으면 -> 부족한 길이만큼의 양수 리턴
        System.out.println("res3 = " + res3);

        CompareToTest t = new CompareToTest();
        t.test();
    }

    public void test() {
        String target2 = "ECDMA";

        if(0 == "ecdma".compareToIgnoreCase(target2)) {
            System.out.println("올바른 파라미터 값");
        }
    }
}
