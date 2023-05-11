package config.annotation;

import makeUtil.masking.Masking;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/************
 * @info : Timer - 어노테이션의 기능 정의
 * @name : TImerRunner
 * @date : 2023/05/11 11:31 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class TImerRunner {

    public static void processAnnotaion(Object o) {
        Class<?> targetClass = o.getClass();
        Method[] declaredMethods = targetClass.getDeclaredMethods();

        for (Method method: declaredMethods) {
            if(method.isAnnotationPresent(Timer.class)) {
                Timer annotation = method.getAnnotation(Timer.class);
                String status = annotation.status();

                System.out.println("@Timer Annotation Enabled!");
                System.out.println("Annotation status = " + status);
            }
        }
    }

    public static void main(String[] args) {
        // 특정 클래스만 target 으로 함.
        // TODO : 지정 하는 모든 패키지의 클래스를 검사해야함.

        // 특정 Class Target
        Masking masking = new Masking();
        processAnnotaion(masking);
//        String res = masking.nameKor("홍길동");
//        System.out.println("홍길동 = " + res);
    }

}
