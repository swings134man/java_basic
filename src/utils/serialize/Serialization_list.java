package utils.serialize;

import utils.serialize.entity.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/************
 * @info : Java 직렬화 - List
 * @name : Serialization_list
 * @date : 2023/07/06 9:40 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Serialization_list {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Object
        Human human1 = new Human("kang", 27);
        Human human2 = new Human("lee", 45);
        Human human3 = new Human("bom", 3);

        String targetFileName = "HumanList.ser";

        // List
        List<Human> list = new ArrayList<>();
        list.add(human1);
        list.add(human2);
        list.add(human3);

        // List to Serialization
        FileOutputStream fos = new FileOutputStream(targetFileName);
        ObjectOutputStream ops = new ObjectOutputStream(fos);
        ops.writeObject(list);

        ops.close();

        /**
         * 역 직렬화 -> Deserialization
         * FILE To Object
         */
        FileInputStream fis = new FileInputStream(targetFileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Human> deSerializedList = (List<Human>)ois.readObject();

        ois.close();

        System.out.println("deSerializedList = " + deSerializedList);
        System.out.println("get 2 = " + deSerializedList.get(2)); // Human{name='kang', age=27}
        System.out.println("get2 get name = "+ deSerializedList.get(2).getName()); // bom
    }//main
}
