package reflection;

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




    }// main
}
