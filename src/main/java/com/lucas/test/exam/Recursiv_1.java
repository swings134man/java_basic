package com.lucas.test.exam;
/**
 * @package : com.lucas.test.exam
 * @name : Recursiv_1.java
 * @date : 2025. 10. 20. 오후 4:35
 * @author : lucaskang(swings134man)
 * @Description: 재귀
**/
public class Recursiv_1 {
    public static void main(String[] args) {
        int result = fact(5);
        System.out.println(result);
    }

    static public int fact(int n) {
        System.out.println("호출 N : " + n);
        if (n <= 2) {
            return 1;
        } else {
            int s = fact(n-2) + fact(n - 1);
            System.out.println("return" + s);
            return s;
        }
    }
}
