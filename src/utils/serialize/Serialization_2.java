package utils.serialize;

import utils.serialize.entity.Human;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/************
 * @info : Java 직렬화 Test 2
 * @name : Serialization_2
 * @date : 2023/07/06 9:33 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 직렬화를 통해 이루어진 파일을 -> Stream 을 통해 역직렬화 한다.
 *
 * -> 외부 파일 -> 자바 객체화 시키는것.
 ************/
public class Serialization_2 {
    public static void main(String[] args) {
        String targetFile = "Human.ser";

        try {
            FileInputStream fis = new FileInputStream(targetFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // byte -> 자바 객체(화)
            Human deSerialized = (Human)ois.readObject();
            System.out.println("deSerialized = " + deSerialized);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
