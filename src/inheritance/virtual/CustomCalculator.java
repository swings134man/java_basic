package inheritance.virtual;

/************
 * @info : 가상 메서드 - Custom Calc
 * @name : Calculator
 * @date : 2023/01/25 4:30 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class CustomCalculator extends Calc{

    void called() {
        System.out.println("called By Sub Class");
    }

    /*
        out : Custom : (a*b)
     */
    @Override
    void calcObj(int a, int b) {
        String res = "Custom : " + (a * b);
        System.out.println(res);
    }
}

