package etc_methods.generics;

/************
 * @info : Java Generic(제네릭) 기초 Main Class
 * @name : Generic_basic_1
 * @date : 2023/02/12 1:13 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 *  - Generic 이란?: data 형식에 의존하지 않고, 하나의 값이 여러가지 데이터 타입들을 가질 수 있도록 하는 방법.
 *      -> 클래스 내부가 아닌, 외부에서 사용자에 의해 타입이 지정되는것을 의미함.
 *      -> ** 특정 타입을 미리 지정하는것이 아닌, 필요에 의해 지정 할 수 있도록 하는것.
 *
 *  - Generic 장점
 *      1. 잘못된 타입이 들어올 수 있는것을 '컴파일 단계'에서 방지 가능.
 *      2. 클래스 외부에서 타입을 지정하기 때문에, 타입을 체크하고 변환해야할 필요가 없다. -> 관리하기 편하다.
 *      3. 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.
 *
 *  - Generic 암묵적인 규칙
 *      1. <T> - Type
 *      2. <E> - Element
 *      3. <K> - Key
 *      4. <V> - Value
 *      5. <N> - Number
 *
 *  - 주의사항
 *      1. T(타입 파라미터) 를 명시 할 수 있는것은 -> Reference Type만 가능하다. -> primitive Type은 안된다.
 *          --> primitive type 을 써야하는 경우 -> Wrapper Class 사용으로 가능하다. (Integer, Double ,,,)
 *      2. 참조 타입이 가능 한다는것은 -> 사용자 정의 Class 또한 Type으로 지정이 가능하다는 의미이다.
 *
 *  - class 뿐 아니라 interface 마찬가지로 적용 가능하다.
 ************/
public class Generic_class {

    public static void main(String[] args) {
        // Generic_Test_1 Class 생성 예제
        // Data Type을 Class 외부에서 정의.
        // Generic_Test_1<String, Integer> t = new Generic_Test_1<String, Integer>(); // T=String, k=Integer

        /*
            1. Generic_Test_1.Class
            - 제네릭 클래스 사용 방법 및 예제.
         */
        Generic_Test_1<String> a = new Generic_Test_1<String>();
        Generic_Test_1<Integer> b = new Generic_Test_1<Integer>();

        a.set("AAA");
        b.set(10);

        // set Data Check
        System.out.println("a data : " + a.get());
        System.out.println("b data : " + b.get());

        // 제네릭 타입 반환 메소드
        System.out.println("a E Type : " + a.get().getClass().getName());
        System.out.println("b E Type : " + b.get().getClass().getName());

        System.out.println("---------------------------------------------------------");
        System.out.println();


        // --------------------------------------------------제네릭 2개 Class Test ----------------------------------------------------------------
        Generic_Test_2<String, Integer> test = new Generic_Test_2<String, Integer>(); // K=String, V=Integer

        test.set("age", 20);

        // K, V
        System.out.println("Key : " + test.getKey());
        System.out.println("value : " + test.getValue());

        // Return Method Type
        System.out.println("K Type: " + test.getKey().getClass().getName());
        System.out.println("V Type: " + test.getValue().getClass().getName());

    }
} // main Class


// Generic Type Class
// - Generic Class 는 -> 객체생성시 구체적인 타입을 명시 해줘야만 한다.
// - 객체 생성시 Type을 지정해주면 E 제네릭 타입은, 명시한 Type 으로 변환된다.
class Generic_Test_1 <E>{

    private E element; // 제네릭 타입 변수

    void set(E element) {   // 제네릭 Parameter Method
        this.element = element;
    }

    E get() {   // 제네릭 타입 return Method
        return element;
    }
} // Generic Test 1

// Generic Type 2개
class Generic_Test_2 <K, V>{

    private K key;
    private V value;

    void set(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

}//Generic Test 2
