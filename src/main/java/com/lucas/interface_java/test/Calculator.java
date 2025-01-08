package com.lucas.interface_java.test;

/************
 * @info : interface - Calculator 기본 기능
 * @name : Calculator
 * @date : 2023/01/25 5:47 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public interface Calculator {

    int AC = 0;

    int add(int a, int b); //더하기
    int min(int a, int b); //뺴기
    int multiple(int a, int b); //곱셈
    int division(int a, int b); // 나누기
}
