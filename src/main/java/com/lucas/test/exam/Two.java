package com.lucas.test.exam;

public class Two {
    public static void main(String[] args) {
        One one = One.get(2);
        one.count();

        One one2 = One.get(3);
        one2.count();
        System.out.println(one.getCount());
    }
}
