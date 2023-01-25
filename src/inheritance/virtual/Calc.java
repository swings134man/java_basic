package inheritance.virtual;

/************
 * @info : 가상 메서드 - Calc 부모클래스
 * @name : Calc
 * @date : 2023/01/25 4:51 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Calc {

    void called() {
        System.out.println("called By Super Class");
    }

    /*
        out : Calc Class : (a+b)
     */
    void calcObj(int a, int b) {
        String res = "Calc Class : "  + (a + b);
        System.out.println(res);
    }

}
