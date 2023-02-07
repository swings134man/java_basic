package reflection;

/************
 * @info : Java Reflection Test Class
 * @name : testReflection
 * @date : 2023/02/08 1:56 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class TestReflection {

    // 전역변수
    private String str1 = "1";
    public String str2 = "2";

    // Constructor
    public TestReflection() {
    }

    public TestReflection(String str) {

    }

    private void method1() {
        System.out.println("method 1 called");
    }

    public void method2(int n) {
        System.out.println("method 2 called, parma is + " + n);
    }

    public void method3() {
        System.out.println("method 3 called");
    }
}
