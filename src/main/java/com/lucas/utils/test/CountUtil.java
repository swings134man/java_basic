package com.lucas.utils.test;

// Util Class 는 상속 불가하도록 final 키워드를 사용한다.: 재정의 불가능
public final class CountUtil {

    // Util Class 는 인스턴스화 할 수 없도록 private 생성자를 정의한다.
    // 관례이다. : 인스턴스화 방지, 의도명확성, 상속방지
    private CountUtil() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static void count(int count) {
        System.out.println("Count: " + count);
    }
}
