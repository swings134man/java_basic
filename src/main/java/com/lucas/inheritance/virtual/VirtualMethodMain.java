package com.lucas.inheritance.virtual;

/************
 * @info : 가상 메서드 - main(자식)
 * @name : VirtualMethodMain
 * @date : 2023/01/25 4:36 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class VirtualMethodMain{

    public static void main(String[] args) {

        int a = 1;
        int b = 2;


        // ----- parent
        Calc c = new Calc();
        c.called();
        c.calcObj(a, b);

        System.out.println();
        // ------ Custom
        CustomCalculator custom = new CustomCalculator();
        custom.called();
        custom.calcObj(a,b);

        System.out.println();
        // ------ Type Super - Custom
        Calc cType = new CustomCalculator();
        cType.called();
        cType.calcObj(a,b);

    }
}
