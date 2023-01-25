package interface_java.test;

/************
 * @info : 계산기 - ComplexCalc 사용.
 * @name : CalculatorMain
 * @date : 2023/01/25 6:22 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class CalculatorMain {

    public static void main(String[] args) {
        int res;

        int a = 10;
        int b = 2;
        double km = 3;
        double mile = 3;

        CalcImpl calc = new CalcImpl();
        System.out.println("add: " + calc.add(a, b));
        System.out.println("min: " + calc.min(a, b));
        System.out.println("mul: " + calc.multiple(a, b));
        System.out.println("div: " + calc.division(a, b));

        System.out.println("toMile: " + calc.kmToMile(km));
        System.out.println("toKm: " + calc.mileToKm(mile));
        System.out.println("addKmMile: " + calc.kmAddMileConvertToKm(km, mile));

        System.out.println();
        res = calc.add(a, b);
        System.out.println("res: "+ res);

        // 초기화 AC
        res = calc.ac;
        System.out.println(res);

    }
}
