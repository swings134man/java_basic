package com.lucas.functional.test;

public class Functional_test2 {
    public static void main(String[] args) {
        boolean init = false;

        // 동작정의 ?
        CustomFun<Boolean> cf = new CustomFun<Boolean>() {
            @Override
            public Boolean test(boolean b) {
                return b;
            }
        };

        Boolean test = cf.test(init);
        System.out.println("com.lucas.test = " + test);

    }
}


@FunctionalInterface
interface CustomFun<T> {
    T test(boolean b);
}