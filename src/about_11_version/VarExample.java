package about_11_version;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/************
 * @info : Java 10 Over Version Uses Keyword - Var (Local Variable Type Inference)
 * @name : VarExample
 * @date : 2023/09/26 10:19 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java 10 부터 사용 가능한 var 키워드 사용 예제
 *
 * var 키워드를 사용하여 지역변수의 타입을 추론할 수 있다.
 *
 * *** 설명
 * 1. var 키워드는 지역변수에만 사용 가능하다.
 * 2. 컴파일 시점에 추론하는것, 즉 RunTime 시점에 연산X -> 컴파일 시점에 타입이 결정된다.
 *    2-2. 만약 컴파일러가 타입 추론X 시 -> 컴파일 에러 발생
 * 3.
 ************/
public class VarExample {

    // 인스턴스 변수의 경우 var 키워드 사용 불가능

    public static void main(String[] args) {
        /**
         * 1. var 키워드 사용 예제
         */
        // String 타입 추론
        var test1 = "this is first"; //String
        if(test1 instanceof String) {
            System.out.println("test1 = " + test1);
        }

        // 다양한 타입 추론 가능
        var testArrayList = new ArrayList<String>();
        if(testArrayList instanceof ArrayList) {
            System.out.println("testArrayList = " + testArrayList);
        }


        List<String> list = List.of("a", "b", "c");
        // for문 에서도 var 키워드 사용 가능
        for(var str : list) {
            System.out.println("str = " + str);
        }

        // 예제 : 컴파일 시점에 list의 타입을 알 수 있으니, var 키워드에 사용가능.
        var testList = list;
        System.out.println("testList = " + testList);


        /**
         * 2. var 키워드 사용 불가능한 경우
         */
//        var test2; // 컴파일 에러 발생 -> var 키워드는 반드시 초기화가 필요하다.
//        var test3 = null; // 컴파일 에러 발생 -> null 은 타입을 추론할 수 없다.
//        var test4 = {1,2,3}; // 컴파일 에러 발생 -> 배열은 타입을 추론할 수 없다.
//        var test5 = () -> {}; // 컴파일 에러 발생 -> 람다식은 타입을 추론할 수 없다.
    }
}
