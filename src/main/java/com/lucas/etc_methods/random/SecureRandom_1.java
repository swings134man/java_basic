package com.lucas.etc_methods.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @package : com.lucas.etc_methods.random
 * @name : SecureRandom_1.java
 * @date : 2026. 2. 27. 오후 9:22
 * @author : lucaskang(swings134man)
 * @Description: Java SecureRandom Class
 * - SecureRandom 클래스는 암호학적으로 강력한 난수 생성기를 제공하는 클래스입니다.
 * - 일반적인 Random 클래스와 달리, 보안적으로 안전한 난수를 생성하기 위해 설계되었습니다. -> 일반 Random 은 예측 가능 난수
 * - SecureRandom 클래스는 다양한 알고리즘을 지원하며, 시스템의 보안 설정에 따라 적절한 난수 생성 알고리즘을 자동으로 선택합니다.
 * - SecureRandom 클래스는 암호화, 인증, 세션 키 생성 등 보안이 중요한 작업에서 사용됩니다.
**/
public class SecureRandom_1 {

    // SecureRandom은 재사용하는 것이 좋음
    private static final SecureRandom secureRandom;

    static {
        try {
            // SHA1PRNG 대신 기본 강력한 알고리즘 사용 권장
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Strong algorithm not available", e);
        }
    }

    public static void main(String[] args) {

        // 1️⃣ 랜덤 정수 생성 (0~100)
        int randomInt = secureRandom.nextInt(100); // 0 ~ 99
        System.out.println("Random Int: " + randomInt);

        // 2️⃣ 랜덤 바이트 생성 (32바이트=256비트) -> 보안 토큰이나 세션 키로 사용 가능(JWT, API 키 등)
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);

        // Base64로 인코딩 -> 바이트 -> 문자열로 인코딩(DB에 저장하거나 URL에 포함할 때)
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        System.out.println("Random Token (Base64): " + token);

        // 3️⃣ 6자리 인증코드 생성예시 (100000 ~ 999999) 앞자리 0 방지
        int authCode = 100000 + secureRandom.nextInt(900000);
        System.out.println("6-digit Auth Code: " + authCode);
    }
}
