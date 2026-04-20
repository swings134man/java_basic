package com.lucas.test.exam;

public class Gisa_06_1_17 {
    private static class Calc {
        int cc(int a, int b) {
            return a + b;
        }

        int cc(char a, char b) {
            return a - b;
        }

        int cc(char c) {
            return c;
        }
    }

    public static void main(String[] args) {
        Calc calc = new Calc();

        int a = calc.cc(5, 4);
        int b = calc.cc('c', 'a');
        int c = calc.cc('3'); // int 면 아스키코드로 51, char 면 '3' 그대로임 -> 기억이 안남

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // answer
        System.out.println(a + b + "2" + c);
    }
}
