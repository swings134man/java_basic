package test.code_test;

import java.util.Arrays;

/************
 * @info : Java - Byte Translate Test
 * @name : ByteTest
 * @date : 2023/03/15 7:05 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class ByteTest {
    public static void main(String[] args) {
        String target = "This is Target String.";

        // String to byte
        byte[] bytes = target.getBytes();
        System.out.println("String = " + target);
        System.out.println("bytes(주소값) = " + bytes);
        System.out.println("bytes = " + Arrays.toString(bytes));

        // byte to String
        System.out.println("------------------------------------------");
        String toStringByte = new String(bytes);
        System.out.println("toStringByte = " + toStringByte);


    }
}
