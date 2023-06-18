package test.code_test;

import java.util.Arrays;

/************
 * @info : 배열 복사 테스트
 * @name : ArrayCopyTest
 * @date : 2023/06/04 1:33 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class ArrayCopyTest {
    public static void main(String[] args) {
        System.out.println("------ 배열 복사 start ------");

        String[] arr1 = new String[]{"a","b","c","d","e"};
        String[] arr2 = arr1; // 얕은 복사

        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1 = " + arr1[i] + " arr2 = " + arr2[i]);
        }

        System.out.println("-----배열 복사 후 값 변경-----");

        arr1[0] = "aa";	// 동일한 참조값으로 변경을 하기 때문에 iArr1 이나 iArr2 모두 변경된 것으로 보임
        arr2[3] = "dd";	// 동일한 참조값으로 변경을 하기 때문에 iArr1 이나 iArr2 모두 변경된 것으로 보임
        for(int i = 0; i < arr1.length; i++) {
            System.out.println("iArr1[" + i + "]:" + arr1[i] + "|iArr2[" + i + "]:" + arr2[i]);
        }

        System.out.println("-----참조값 확인-----");
        System.out.println("arr1 참조값 : " + arr1);
        System.out.println("arr2 참조값 : " + arr2);
        System.out.println("--------------------");

        /*
            Deep Copy
         */
        String[] deep1 = arr1.clone(); // aa, b, c, dd, e
        System.out.println("deep :" + Arrays.toString(deep1));

        deep1[0] = "a";
        System.out.println("arr1 : " + Arrays.toString(arr1));
        System.out.println("deep :" + Arrays.toString(deep1));
    }//main
}
