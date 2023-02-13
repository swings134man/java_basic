package etc_methods.wrapper;

/************
 * @info : Java Wrapper Class Basic
 * @name : WrapperClass_1
 * @date : 2023/02/13 5:39 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java Wrapper Class(래퍼 클래스)
 *
 * - Wrapper Class 란? : Primitive 자료형을, 객체로 다루기 위해서 사용되는 Class.
 *      -> 기본 자료형 데이터를 객체로 표현해야 할 때 사용됨.
 *      -> Primitive의 값을 Wrapper Class 내부에 두고 객체로 포장한다.
 *      -> 기본타입 -> Wrapper Class : 박싱
 *      -> Wrapper Class -> 기본타입 : 언박싱
 *
 * - 박싱, 언박싱 : 기본타입을 Wrapper로 박싱, Wrapper를 기본타입으로 언박싱이라고 한다.
 *      -> 언박싱: Wrapper 객체에서 기본타입의 값을 얻어내는 과정이다.
 *      -> 오토 박싱, 언박싱 : 자동으로 박싱, 언박싱이 일어나는 경우 : EX) Integer i = 10; // 오토 박싱, int j = i; // 오토 언박싱
 *
 * - Wrapper Class 종류 : 래퍼클래스(기본타입)
 *      1. Byte(byte)
 *      2. Character(char)
 *      3. Integer(int)
 *      4. Float(float)
 *      5. Double(double)
 *      6. Boolean(boolean)
 *      7. Long(long)
 *      8. Short(short)
 *
 *  - 구조도 : Object(최상위) - Boolean, Character, Number(Byte,Short,Integer,Long,Double,Float, "BigInteger", "BigDecimal")
 *
 *  - 비교: Wrapper Class는 객체이기 때문에, equals()를 사용하여 비교해야한다.(주소값 비교)
 *
 *  - 주의할점
 *      1. 큰값에서 -> 작은값으로 강제 형변환 진행시 Data가 유실될 가능성이 크다.
 *          - 최대값 최소값 비교 후 강제 캐스팅을 진행하는게 안전하다.
 *      2. 타입별 크기 (byte)
 *          - byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
 *
 ************/
public class WrapperClass_1 {
    public static void main(String[] args) {
        // Integer
        Integer i1 = new Integer(10); // Boxing
        int ir1 = i1.intValue(); // UnBoxing
        System.out.println("Integer: " + i1.getClass().getName()); // Integer type + Value : i1=10
        System.out.println("Integer To int: " + ir1);
        System.out.println();

        //  Auto Boxing & UnBoxing
        Integer i2 = 20; //Auto Boxing
        int ir2 = i2; // Auto UnBoxing
        System.out.println("Auto Integer : " + ir2);
        System.out.println();

        // 문자열 to 기본타입.
        String str1 = "100";
        String str2 = "200.5";
        String str3 = "true";

        byte b = Byte.parseByte(str1);
        int i = Integer.parseInt(str1);
        short s = Short.parseShort(str1);
        long l = Long.parseLong(str1);

        float f = Float.parseFloat(str2);
        double d = Double.parseDouble(str2);

        boolean bool = Boolean.parseBoolean(str3);

        System.out.println("byte : " + b);
        System.out.println("int : " + i);
        System.out.println("short : " + s);
        System.out.println("long : " + l);
        System.out.println("float : " + f);
        System.out.println("double : " + d);
        System.out.println("boolean : " + bool);


        // 강제 형변환
        // 큰것 -> 작은것, 으로 변환할때 오류가 생기지 않도록하는것.
        int res = 10000000; // 천만
        byte resb = (byte)res; // int 형 -> byte 강제 형변환.
        System.out.println(resb); // -128: byte 가 표현할 수 있는 최소값.

        int res1 = 10;
        byte resb2 = (byte)res1;
        System.out.println(resb2);

        // 강제 형변환 체크
        int casI = 127; // target

        if(casI < Byte.MIN_VALUE || casI > Byte.MAX_VALUE) { // i< -128 || i>127
            System.out.println("byte 타입으로 변환 불가능.");

        } else {
            byte bres = (byte)casI;
            System.out.println("byte 형변환 : " + bres);
        }

    }//main
}//class
