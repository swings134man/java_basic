package com.lucas.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

/************
 * @info : Java Reflection - main Class (실행)
 * @name : Reflection_main
 * @date : 2023/02/08 1:55 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java Reflection 이란 ?
 *
 * - 클래스, 인터페이스, 메소드들을 찾을 수 있고, 객체를 생성하거나, 변수를 변경 할 수 있고, 메소드를 호출 할 수도 있다.
 ************/
public class Reflection_main {

    public static void main(String[] args) throws Exception{
        // 호출해야할 대상 객체
        TestReflection test = new TestReflection();

        // Class target = Class.forName("TestReflection"); // 클래스 이름으로 info get
        Class target = TestReflection.class; // java.lang.Class : not to import

        // class Name
        System.out.println("Class Name: "+ target.getName());

        // ---------------------------------------------- Constructor --------------------------------------------------------------
        /*
            Constructor 찾기
            1. 파라미터 없는 생성자.
            2. 파라미터가 있는 생성자. -> 타입과 일치해야함.
            3. 모든 파라미터 - private, public
         */
        // Class Constructor - 생성자 찾기
        Constructor declaredConstructor = target.getDeclaredConstructor();
        System.out.println("Constructor: " + declaredConstructor.getName());

        // Parameter 가 있는 생성자 찾기 - 타입과 일치하는
        Constructor declaredConstructor2 = target.getDeclaredConstructor(String.class);
        System.out.println("Constructor(String): " + declaredConstructor2.getName());

        // private, public 모든 생성자 찾기
        // public 생성자만 찾을 경우 ---> target.getConstructors();
        Constructor[] allCons = target.getDeclaredConstructors();
        for (Constructor cons: allCons) {
            System.out.println("All Constructor : " + cons);
        }
        System.out.println();
        // ---------------------------------------------- Method --------------------------------------------------------------

        /*
            Method 를 찾는 방법
            1. 이름, 파라미터로 찾기(파라미터가 없다면 null 전달) -> 파라미터가 여러개라면 배열로 만들어서 넣어준다.
            2. 모든 메서드 찾기
            3. public 메서드만 찾기 -> 상속받은 메서드도 찾아준다.
         */
        // 1
        Method findNameParam = target.getDeclaredMethod("method2", int.class);

        // 2 - All Methods (private, public)
        Method[] allMethods = target.getDeclaredMethods();
        for(Method all : allMethods) {
            System.out.println("All Methods: " + all);
        }
        System.out.println();

        // 3 - 상속받은 모든것. 및 public Method
        Method[] allPublicMehtods = target.getMethods();
//        for(Method pub : allPublicMehtods) {
//            System.out.println("All public Methods: " + pub);
//        }
        System.out.println();

        // ---------------------------------------------- Field --------------------------------------------------------------
        /*
            Field
            1. 특정 필드 검색.
            2. 모든 필드 검색. (상속받은 객체 X) -> private, public
            3. 상속받은 클래스 포함 모든 public Field
            4. Field 변수 변경
            5. private Field 접근 및 변수 변경.
         */

        // 1 - 특정필드 검색
        Field str = target.getDeclaredField("str1");

        // 2 - 모든 필드(private, public)
        Field[] allField = target.getDeclaredFields();
        for (Field all:allField) {
            System.out.println("Field : " + all);
        }

        // 3 - 상속 포함 모든 필드
//        target.getFields();

        // 4 - Field 변경. (str2="2")
        Field str2 = target.getField("str2");
        System.out.println("Field str2: " + str2.get(test)); // get(대상 객체를 넘겨야함.) = 2
        str2.set(test, "changed str2");
        System.out.println("Field str2: " + str2.get(test)); // = changed str2

        // 5 - private Field 변경 (str1="1")
        Field str1 = target.getDeclaredField("str1");
        str1.setAccessible(true); // Private 접근 활성화 (true)
        System.out.println("field private : " + str1.get(test));
        str1.set(test, "str1 changed");
        System.out.println("field private set : " + str1.get(test));

        System.out.println();
        // ---------------------------------------------- Method --------------------------------------------------------------
        /*
            Method 호출. - Class의 Method 정보를 가져와, 호출 가능.
            1. 메소드 객체 찾아서 invoke() 호출.
            2. private Method 접근.
         */

        // 1 - (호출하려는 객체, 전달할 파라미터값)
        Method method4 = target.getDeclaredMethod("method4", int.class);
        int invoke = (int)method4.invoke(test, 3); // return 4
        System.out.println("method return : "+ invoke);

        // 2 - private Method 접근
        Method method1 = target.getDeclaredMethod("method1");
        method1.setAccessible(true); // Private 접근 true(접근가능)
        method1.invoke(test);

        System.out.println();
        // ---------------------------------------------- Static 접근 --------------------------------------------------------------
        /*
            Static Field 변경,호출 -  Method 호출 -> 객체를 전달하는 param 을 null 로 넣어야함.
            1. static Method 호출
            2. static field - get, set (대상 클래스 파라미터에 객체 대신, null 을 넣어야함.)
         */

        // 1
        Method testStatic = target.getDeclaredMethod("testStatic", int.class);
        int invoke1 = (int)testStatic.invoke(null, 10);
        System.out.println("static method : " + invoke1);

        // 2
        Field example = target.getDeclaredField("EXAMPLE");
        System.out.println("static field : " + example.get(null));

        example.set(null, "Hello World");
        System.out.println("static field changed: " + example.get(null));

    }// main
}
