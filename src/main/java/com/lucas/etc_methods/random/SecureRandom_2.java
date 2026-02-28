package com.lucas.etc_methods.random;

import java.security.SecureRandom;

/**
 * @package : com.lucas.etc_methods.random
 * @name : SecureRandom_2.java
 * @date : 2026. 2. 28. 오후 6:56
 * @author : lucaskang(swings134man)
 * @Description: Java SecureRandom Sample Class
 * - SecureRandom 클래스를 사용하여 25 자리의 Crockford Base32 문자열을 생성하는 샘플 코드입니다.
**/
public class SecureRandom_2 {

    // Java SecureRandom - 25 자리의 Crockford Base32 문자열 생성 샘플
    // - Crockford Base32는 0-9, A-Z (I, L, O, U 제외)로 구성된 32진수 인코딩 방식입니다.
    // 별도의 SecureRandom static 인스턴스를 사용하여 재사용 가능하도록 구현

    private static SecureRandom secureRandom = null;

    public static void main(String[] args) {
        secureRandom = new SecureRandom(); // 기본 강력한 알고리즘 사용
        String randomString = generateRandomBase32(25);
        System.out.println("Random Crockford Base32 String: " + randomString);
    }

    public static String generateRandomBase32(int length) {
        // Crockford Base32 문자 집합 (I, L, O, U 제외)
        final String BASE32_CHARS = "0123456789ABCDEFGHJKMNPQRSTVWXYZ";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(BASE32_CHARS.length());
            sb.append(BASE32_CHARS.charAt(randomIndex));
        }

        // 5자리마다 하이픈 추가 (예: XXXXX-XXXXX-XXXXX-XXXXX-XXXXX)
        for (int i = 5; i < sb.length(); i += 6) {
            sb.insert(i, '-');
        }

        return sb.toString();
    }



}
