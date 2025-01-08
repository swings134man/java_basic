package com.lucas.etc;

import java.util.Arrays;

/************
 * @info : ABOUT Base64 Encoding
 * @name : Encoding_Base64
 * @date : 5/21/24 10:37 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Base64 Encoding 이란?
 *
 *  Base64 Encoding 은 바이너리(이진데이터)를 텍스트로 변환하는 인코딩 방식.(사람이 읽을 수 있는 형태로 변환)
 *  -> 64의 뜻은 64개의 문자로 이루어진 문자열로 변환한다는 의미.(A-Z, a-z, 0-9, +, /) -> 연산중 모자라는 비트 존재시,, '=' 문자로 채워진다.
 *
 *  Base64 Encoding 은 웹에서, binary 데이터를 safe 하게 전송하기 위해 개발되었음.
 *  EMail 과 같은 텍스트 기반 프로토콜에서는 binary 데이터를 전송할 수 없기 때문임.
 *      -> Email, image, 첨부파일과 같은 데이터는 Base64 Encoding 이후 문자열로 변환되어 전송됨.
 *
 *  즉, 바이너리 데이터를 텍스트로(ASCII) 변환하는 인코딩 방식이다.
 *
 *  사용방식?
 *  1. 문자열을 Binary 데이터로 변환.
 *  2. Binary 데이터를 Base64로 인코딩.
 *
 *
 * - ASCII 문자열을 64개의 문자로 이루어진 문자열로 변환하는 인코딩 방식
 * - ASCII 문자열은 대부분의 컴퓨터 및 통신 시스템에서 지원한다.
 *
 * - utf-8 은 8비트 유니코드 인코딩 방식이다.
 *   -> unicode 를 어떤 방식으로 변환하는지.
 ************/
public class Encoding_Base64 {
    public static void main(String[] args) {
        String sampleText = "Hello, World!";

        // to UTF-8(UniCode)
        byte[] utf8 = sampleText.getBytes(java.nio.charset.StandardCharsets.UTF_8);

        // To ASCII (Byte)
        byte[] bytes = sampleText.getBytes();

        // To Base64
        String base64 = java.util.Base64.getEncoder().encodeToString(bytes);

        System.out.println("Arrays.toString() = " + Arrays.toString(utf8));
        System.out.println("ASCII mem loc = " + bytes);
        System.out.println("bytes" + Arrays.toString(bytes));

        System.out.println("base64 = " + base64);
    }
}
