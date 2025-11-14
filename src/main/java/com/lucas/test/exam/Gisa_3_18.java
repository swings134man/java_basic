package com.lucas.test.exam;

/**
 * @package : com.lucas.test.exam
 * @name : Gisa_3_18.java
 * @date : 2025. 11. 14. 오후 5:50
 * @author : lucaskang(swings134man)
 * @Description: 3회차 18번
**/
public class Gisa_3_18 {

    public static void main(String[] args) {
        int x=7, y=4, z;

        z= y%3>0 ?2:1;
        System.out.println(z); // z=2

        // 10 & 10 -> 1 & 1 -> 1 -> 오른쪽 1칸 시프트 -> 0
        z= z&z>>1;
        System.out.println(z);

        // z/x -> 0 => 0/7 -> 0
        z= x > 5 && z <= 3 ? z*x: z/x;

        System.out.println(z);
    }
}
