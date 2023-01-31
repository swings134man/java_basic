package collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/************
 * @info : Java - Map 기본
 * @name : Map_basic
 * @date : 2023/01/31 6:43 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * - Java Collection - Map
 * 1. Map 에는 3종류가 있다. HashMap, TreeMap, HashTable
 *
 * - Key, value 쌍으로 이루어진 데이터 집합.
 * - 순서X, Key 값 중복X, Value 값 중복 허용
 *
 ************/
public class Map_basic {
    public static void main(String[] args) {
        hash_map();

    }// main


    //Hash Map
    public static void hash_map() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 4); // Val 중복!
        map.put("e", 5); // Key 중복! -> 기존 Key 값의 Value에 덮어씌워진다.

        System.out.println(map); //전체값 : {a=1, b=2, c=3, d=4, e=5}
        System.out.println(map.get("c")); // Key 값을 통해 Value를 가져올 수 있음 - 3
        System.out.println("---------------------------------------");

        // entrySet() - map 의 데이터를 하나씩 가져와 객체화 할수 있음.
        // set이나 List와 같은 컬렉션에 따로 저장 가능.
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
        System.out.println("---------------------------------------");

        // keySet() - entrySet()과 달리 Key 값만을 추출할 수 있음.
        // ****** KeySet 으로 key 추출 후 Value 를 재 검색 하는것은 성능저하로 연결된다. 사용시 entrySet이나 iterator 사용 권장. ******
        for (String key: map.keySet()) {
            System.out.println("Key : " + key);
        }
        map.remove("e"); //Key 값 삭제.
        System.out.println("---------------------------------------");

        // Iterator 를 통해 전체 출력 가능.
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key : " + key + " Value : " + map.get(key));
        }

        map.clear(); // map 의 내용 전부 삭제
        System.out.println("map 내부 요소 : " + map.size());

    }// HashMap


}
