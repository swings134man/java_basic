package etc_methods.generics.wildcard;


/************
 * @info : Java Generic Wild Card Basic
 * @name : Generic_wildcard
 * @date : 2023/02/13 9:17 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java Generic wildCard 개념
 *
 * - Generic Type의 특정범위 내로 제한 할때 사용.
 *
 *
 * - KeyWords
 *  1. extends
 *  2. super
 *  3. ?
 *
 *  - 사용 예시
 *      1. <K extends T> : T자신과, T의 하위 타입만 가능(자손), K는 들어오는 타입임(param)
 *      2. <K super T> : T자신과, T의 부모타입만 가능. K는 들어오는 타입임(param)
 *
 *      3. <? extends T>: T와 T의 자손 타입만 가능. (상한경계)
 *      4. <? super T> : T와 T의 부모 타입만 가능. (하한경계)
 *      5. <?>: 모든 타입 가능 - <? extedns Object>와 같은 의미. (와일드카드)
 *
 *
 ************/
public class Generic_wildcard {
    public static void main(String[] args) {
        type_limit1<Integer> t = new type_limit1<Integer>();
        t.setElement(new Integer(100));

        Integer integer = t.get();
        System.out.println("K type is : " + integer.getClass().getName());

//        type_limit1<String> t2 = new type_limit1<String>(); // error -> String 타입은 Number Class에 속해있지않음.

    }//main
}//class

/*
    - extedns Number class
    1. Number Class와 하위타입 (Integer, Byte, Long, Float Double, Short) 가능.
 */
class type_limit1 <K extends Number>{
    private K element;

    void setElement(K k) { // K타입 Set
        this.element = k;
    }

    K get() {
        return element;
    }
}// class type1
