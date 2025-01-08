package com.lucas.utils.serialize;

import com.lucas.utils.serialize.entity.Human;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/************
 * @info : Java 직렬화 Test 1
 * @name : Serialization_1
 * @date : 2023/07/06 9:23 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 직렬화(Serialization) 내보내기
 *
 * -> 자바 객체를 -> 파일 형식의 Data 로 변환
 *
 * -> 직렬화란 자바 Object 또는 Data를 다른 Computer의 자바 시스템에서도 사용할 수 있도록 Byte Stream 형태의 데이터로 변환하는 기술.
 ************/
public class Serialization_1 {

    public static void main(String[] args) {
        Human human = new Human("kang", 27);

        String fileName = "Human.ser"; // ser 확장자, 또는 .obj 로 사용하여 직렬화된 파일이라는 것을 명시한다.

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(human);
        }catch (IOException e){
            e.printStackTrace();
        }



    }//main
}
