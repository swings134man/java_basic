package etc_methods.generics;

/************
 * @info : Java Generic - Method 활용 Class
 * @name : Generic_method
 * @date : 2023/02/13 4:54 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : generic Mehtod 활용법.
 *
 *  - Generic Method를 static 하게 사용하는 방법!
 *      - 별도 메서드에 한정한 제네릭 타입활용.
 *          -> 즉 Class에서 지정한 Generic type과 별도로, 독립적인 Generic Type 을 선언하여 사용할 수 있다.
 *
 *  - 제네릭 메서드 선언 예제 : public <T> T method1(T o){} - [접근제어자] <제네릭타입> [반환타입] [메소드명]([제네릭타입] [파라미터])
 *
 * - Generic Mehtod : 파라미터 타입에 따라 T 타입이 결정된다.
 *
 * - 주의사항
 *  1. Static Mehtod는 Class 타입으로 지정하게 된다면, Error(객체가 생성되기 전에 메모리에 올라가기 때문에 -> type을 알수 없음.)
 *      -> 해결 방법: 독립적인 Generic Method를 활용하면 된다.
 *
 ************/
public class Generic_method {

    public static void main(String[] args) {
        // String
        Generic_method_test1<String> t1 = new Generic_method_test1<String>();
        t1.setElement("type of String");

        System.out.println("E element: " + t1.get()); // set 파라미터
        System.out.println("E type : " + t1.get().getClass().getName()); // 파라미터 타입
        System.out.println("제네릭 메서드 Value: " + t1.genericMethod("method")); // 제네릭 메소드 타입.
        System.out.println("제네릭 메서드 Type: " + t1.genericMethod("method").getClass().getName()); // 제네릭 메소드 타입.
        System.out.println();

        // Integer
        Generic_method_test1<Integer> t2 = new Generic_method_test1<Integer>();
        t2.setElement(100);

        System.out.println("E element: " + t2.get());
        System.out.println("E Type: " + t2.get().getClass().getName());
        System.out.println("제네릭 메서드 Value: " + t2.genericMethod(200));// 제네릭 메소드 타입.
        System.out.println("제네릭 메서드 Type: " + t2.genericMethod(200).getClass().getName());// 제네릭 메소드 타입.
    }
}// main class

/*
    - Generic Methods Class
 */
class Generic_method_test1<E> {

    private E element;
    void setElement(E e){
        this.element = e;
    }

    // 제네릭 타입 return Method
    E get() {
        return element;
    }

    // 제네릭 메소드 - Parameter 타입에 따라 'T' 타입이 결정된다.
    <T> T genericMethod(T o) {
        return o;
    }

    /*
        - Error
        Class 와 같은 E 타입이더라도
        Static Method는 객체가 생성되기 이전에 메모리에 올라가기 때문에
        E 타입을 클래스로 부터 얻어올 방법이 없다.
     */
//    static E errorMehtod(E o) {
//        return o;
//    }

    /*
        - generic type : Static 으로 사용하는 방법
     */
    static <E> E staticGeneric1(E o) { // 제네릭 메서드1
        return o;
    }

    static <T> T staticGeneric2(T o) { // 제네릭 메서드2
        return o;
    }
}
