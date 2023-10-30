package functional.ex1;

import java.util.function.Consumer;

public class Call_consumer {

    public static void main(String[] args) {
        System.out.println("Start Main " + Thread.currentThread().getName());

        getResult(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                var nextValue = integer + 1;
                assert nextValue == 1;
                System.out.println("nextValue = " + nextValue);
            }
        });

        System.out.println("Finish main");
    }

    public static void getResult(Consumer<Integer> cb) {
        System.out.println("Start getResult = " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var result = 0;
        cb.accept(result);
        System.out.println("value = " + result);
        System.out.println("Finish getResult");
    }







}
