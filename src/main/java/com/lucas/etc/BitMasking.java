package com.lucas.etc;

/**
 * @package : com.lucas.etc
 * @name : BitMasking.java
 * @date : 2025. 1. 22. 오후 5:36
 * @author : lucaskang(swings134man)
 * @Description: Java 비트마스킹 기본
**/
public class BitMasking {
    public static void main(String[] args) {
        /**
         * 비트 마스킹은 비트 연산을 이용하여 특정 비트를 켜거나 끄는 기법을 말한다.
         * 비트는 int 형태로 32비트로 이루어져 있으며, 0부터 31까지의 인덱스를 가진다.
         * 다른 타입이더라도 int 형태로 변환하여 비트 연산을 수행한다.
         */

        // 1. 샘플
        int x = 5; // 0 0 1 0 1
        int y = 19;// 1 0 0 1 1

        // 2. 비트 연산
        // 2-1. AND 연산
        int xAndY = x & y; // 0 0 0 0 1 : 2개 대상중 양쪽 모두 1인것만 내보낸다. (둘다 1이어야 1)

        // 2-2. OR 연산
        int xOrY = x | y; // 1 0 1 1 1 : 2개 대상중 한쪽이라도 1인것을 내보낸다. (둘중 하나라도 1이면 1)

        // 2-3. XOR 연산
        int xXorY = x ^ y; // 1 0 1 1 0 : 2개 대상중 한쪽이 1이고 다른 한쪽이 0인것을 내보낸다. (둘중 하나만 1이어야 1) 즉 같으면 0, 다르면 1

        // 2-4. NOT 연산
        int notX = ~x; // 1 1 0 1 0 : 0을 1로, 1을 0으로 바꾼다. 정수의 경우 x + 1에 -를 붙인값이 나온다. ~x == -6

        // 2-5. SHIFT 연산
        int shiftLeftX = x << 1; // 0 1 0 1 0 : 왼쪽으로 1칸씩 이동
        int shiftRightX = x >> 1; // 0 0 0 1 0 : 오른쪽으로 1칸씩 이동


    }
}
