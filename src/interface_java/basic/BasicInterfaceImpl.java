package interface_java.basic;

/************
 * @info : interface - 구현체(1)
 * @name : BasicInterfaceImpl
 * @date : 2023/01/25 5:43 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class BasicInterfaceImpl implements Basic_Interface{

    String basic;

    /*
        interface 의 Field 값.
     */
    public void field() {
        System.out.println("Basic Filed -> " + BASIC_RES);
        this.basic = BASIC_RES;
    }


    /*
        interface - Override(재정의) 메서드
     */
    @Override
    public void called(String param) {
        System.out.println("this is impl param is -> " + param);
    }

    @Override
    public void callBy(String param) {
        System.out.println("this is impl param is -> " + param);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
