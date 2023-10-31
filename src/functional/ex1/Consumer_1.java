package functional.ex1;

import java.util.function.Consumer;

/************
 * @info : Java - Consumer interface Ex1
 * @name : Consumer_1
 * @date : 2023/10/31 11:04 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * Consumer interface 는 Functional interface 이다.
 * - 1개의 제네릭 타입을 매개변수로 사용한다.
 * - 리턴값이 없다.
 * - (추상메서드)accept(), (디폴트메서드)andThen() 2개의 메서드를 갖고있다.
 * -
 ************/
public class Consumer_1 {

    public static void main(String[] args) {

        Consumer<Integer> ci = (num) -> System.out.println(num + " * 10 = " + (num * 10));

        // accept()는 매개변수를 받아서 소비만 하고, 리턴값이 없다.
        ci.accept(1);
        ci.accept(2);
        ci.accept(3);

        // andThen() - accept()를 실행 후, 다른 Consumer를 실행한다.
        // -> Consumer를 연결해서 사용할 수 있다. cs1 -> cs2 -> cs3 순차적 실행 가능하다는 의미
        Consumer<String> cs1 = (str) -> System.out.println(str + "1");
        Consumer<String> cs2 = (str) -> System.out.println(str + "2");
        Consumer<String> cs3 = (str) -> System.out.println(str + "3");

        cs1.andThen(cs2.andThen(cs3)).accept("test");

        // andThen() - ex2
        Consumer<Integer> ci1 = (num) -> System.out.println(num + " + 10 = " + (num + 10));
        Consumer<Integer> ci2 = (num) -> System.out.println(num + " - 10 = " + (num - 10));
        Consumer<Integer> ci3 = (num) -> System.out.println(num + " * 10 = " + (num * 10));

        ci1.andThen(ci2.andThen(ci3)).accept(10);

        // -----------------
        // Under class Test
        // Class 내부의 정의된 return 값이 Consumer<T> 인 메서드의 경우, 해당 로직을 실행후 종료.
        CarConsume cc = new CarConsume();
        cc.consume().accept("BMW");
    }
}// main class

class CarConsume {
    public Consumer<String> consume() {
        return (str) -> {
            System.out.println("input car name = " + str);
        };
    }
}
