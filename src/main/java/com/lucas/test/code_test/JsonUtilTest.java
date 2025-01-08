package com.lucas.test.code_test;

import com.lucas.utils.json.JsonUtil;

import java.util.List;
import java.util.Map;

/************
 * @info : Json Util com.lucas.test
 * @name : JsonUtilTest
 * @date : 12/5/23 10:01 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class JsonUtilTest {

    public static void main(String[] args) {
        JsonUtil util = new JsonUtil();

        //[{"name":"kang","age":27},{"name":"bom","age":3}]
        String test = "[{\"name\":\"kang\",\"age\":27},{\"name\":\"bom\",\"age\":3}]";

        Map<String, Object> stringObjectMap = util.jsonToMap(test);
        for (Map.Entry<String, Object> map : stringObjectMap.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }

        System.out.println();

        List<Map<String, Object>> maps = util.jsonToMapV2(test);
        maps.stream().forEach(System.out::println);
        System.out.println(maps);
    }
}
