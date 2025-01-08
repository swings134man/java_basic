package com.lucas.functional.test;

/************
 * @info : Functional interface 사용 테스트1
 * @name : Functional_test1
 * @date : 2023/10/31 11:32 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Functional_test1 {

    public static void main(String[] args) {
        FunctionRun fr = new FunctionRun();
        fr.start("method start");

        FunctionRun fr2 = new FunctionRun("init param");
        fr2.start();

    }
}

interface Run<T> {
    void start();

    void start(String str);

}

class FunctionRun implements Run<String> {

    String defaultString;

    public FunctionRun() {}

    public FunctionRun(String init) {
        this.defaultString = init;
    }

    @Override
    public void start() {
        System.out.println(defaultString);
    }

    @Override
    public void start(String str) {
        System.out.println(str);
    }
}
