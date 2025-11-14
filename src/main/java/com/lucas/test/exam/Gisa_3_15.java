package com.lucas.test.exam;

import java.util.Arrays;

/**
 * @package : com.lucas.test.exam
 * @name : Gisa_3_15.java
 * @date : 2025. 11. 14. 오후 6:05
 * @author : lucaskang(swings134man)
 * @Description: 3회차 15번
 * - enum 의 name 은 열거형 상수의 이름을 문자열로 반환
 * -
**/
public class Gisa_3_15 {

    enum Tri {
        AB("A"), A("AB"), C("ABC");

        private String code;

        Tri(String a) {
            this.code = a;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }


    public static void main(String[] args) {
        Tri a = Tri.values()[Tri.A.name().length()];
        System.out.println(a.getCode());

        System.out.println(Arrays.toString(Tri.values())); // [AB, A, C]
        System.out.println(Tri.A.name()); // A = 1
        System.out.println(Tri.values()[1].getCode()); // AB = (A)
    }

}
