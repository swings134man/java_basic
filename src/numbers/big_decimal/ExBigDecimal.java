package numbers.big_decimal;

import java.math.BigDecimal;

/************
 * @info : Java - BigDecimal
 * @name : BIgDecimal
 * @date : 2023/05/27 11:19 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 소수점 이하의 정확한 수를 다뤄야 할 때 사용한다.
 *
 * double 타입의 문제점 -> 이진수의 근사치를 저장하기 때문에, 10진수로 변환하는 과정에서 값이 달라진다.
 * a=6.999999999 일때 -> 실제값:7 로 출력된다.
 * EX) 5.6 + 5.8 = 11.3999999999...
 *
 * BigDecimal 타입은 내부적으로도 10진수로 저장하여, 아주 작은수, 큰수의 연산에 대해 거의 무한한 정밀도를 보장한다.
 *
 ************/
public class ExBigDecimal {

    private static void exampleOfDouble() {
        double a = 10.0000;
        double b = 3.0000;

        // + -> 기대값 11.4
        double total = 0;
        total += 5.6;
        total += 5.8;
        System.out.println("total = " + total);

        // - -> 기대값 7
        System.out.println("- : " + (a - b));

        // * -> 기대값 30
        System.out.println("* : " + (a * b));

        // / -> 기대값 3.3333...
        System.out.println("/ : " + (a / b));
    }

    private static void decimalDef() {
        // 흔히 쓰이는 값은 상수로 정의 되어있음.
        BigDecimal one = BigDecimal.ONE; // 1
        BigDecimal zero = BigDecimal.ZERO; // 0
        BigDecimal ten = BigDecimal.TEN; // 10


        /*
            val 를 0.01(double) 타입으로 그대로 초기화하면 기대값과 다름.
            -문자열로 초기화 해야함.
         */
        BigDecimal a = new BigDecimal("0.01");
        BigDecimal b = new BigDecimal("0.03");
        // 혹은
        BigDecimal.valueOf(0.01);

        /*
            비교 연산
            - equals : 소수점 까지 모든 값이 완전히 동일해야 true -> 소수점 맨 끝의 0 까지 비교함.
            - compareTo : 값 비교 -> 소수점 맨끝 0 무시 값 동일시 0, 적으면 -1, 많으면 1을 반환함.
         */
        a.equals(b); //false
        a.compareTo(b); // -1

        /**
         * 사칙연산
         *
         * 더하기: add
         * 빼기 : subtract
         * 곱하기: multiply
         * 나누기: divide
         * 나누기 후 나머지 : remainder
         * 절대값 : new BigDecimal("3").abs();
         * 두수중 최소값 : a.min(b);
         * 두수중 최대값 : a.max(b);
         */
    }

    public static void main(String[] args) {
        exampleOfDouble();
    }
}
