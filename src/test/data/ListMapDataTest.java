package test.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/************
 * @info : Java - List<Map<>> Test Class
 * @name : ListMapDataTest
 * @date : 2023/05/03 8:59 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : resultMap 으로 반환시에, 조건에 따라 map에 데이터 추가
 ************/
public class ListMapDataTest {

    public static void main(String[] args) {
        System.out.println("Test");
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Map<String, Object> map1 = new LinkedHashMap<>();
            for (int j = 0; j < 5; j++) {
                map1.put("mapKey" + j, "mapData" +j);
            }
            list.add(map1);
        }

        // 리스트 조회 list = [{1},{2},{3}]
        System.out.println("list = " + list);

        // 리스트 꺼내기 -> map
        System.out.println("List 요소 꺼내기 = " + list.get(0));

        // 리스트 인덱스에(map) 데이터 추가
        list.get(0).put("AddKey", "AddVal1");
        System.out.println("List 0 idx 에 key-val 추가 = " + list.get(0)); //{mapKey0=mapData0, mapKey1=mapData1, mapKey2=mapData2, mapKey3=mapData3, mapKey4=mapData4, AddKey=AddVal1}

        // 리스트 내부의 map 데이터 조건에 따라 데이터 추가
        if(list.get(1).get("mapKey0").equals("mapData0")){
            list.get(1).put("IfTestData", "TestData1");
            System.out.println("조건부 데이터 insert = "+ list.get(1));
        }
    }//main

}//class
