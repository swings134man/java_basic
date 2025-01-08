package com.lucas.test.code_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.utils.serialize.entity.Human;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/************
 * @info : 
 * @name : JsonTestOne
 * @date : 2023/07/13 9:16 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 
 ************/
public class JsonTestOne {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonTestOne t = new JsonTestOne();
        JSONArray jsonArray = t.testData();

        List<Human> human = (List<Human>) mapper.readValue(jsonArray.toJSONString(), Human.class);
        human.stream().forEach(System.out::println);
    }

    public JSONArray testData() {
        // 1. Java Object -> JSON
        JSONObject jo = new JSONObject();
        jo.put("name", "kang");
        jo.put("age", 27);

        JSONObject jo2 = new JSONObject();
        jo2.put("name", "bom");
        jo2.put("age", 3);

        // 2. make array
        JSONArray ja = new JSONArray();
        ja.add(jo);
        ja.add(jo2);

        System.out.println("ja = " + ja); //ja = [{"name":"kang","age":27},{"name":"bom","age":3}]

        return ja;
    }

    public void testResponse() {
//        {
//            "header": {
//            "isSuccessful": true,
//                    "resultCode": 0,
//                    "resultMessage": ""
//        },
//            "location": {
//            "result": true,
//                    "hasAdmAddress": true,
//                    "adm": {
//                "posx": "126.982859",
//                        "posy": "37.476414",
//                        "address": "서울특별시 서초구 방배동",
//                        "distance": 0,
//                        "bldname": "방배모범운전자회",
//                        "bldnum": "",
//                        "admcode": "1165010100",
//                        "postcode": "06760",
//                        "jibun": "504-1",
//                        "roadname": "서울특별시 서초구 남부순환로",
//                        "roadjibun": "2106"
//            },
//            "adm_address": {
//                "address": "서울특별시 서초구 방배2동",
//                        "admcode": "1165061000",
//                        "address_category3": "방배2동",
//                        "address_category4": "",
//                        "jibun": "504-1",
//                        "address_category1": "서울특별시",
//                        "address_category2": "서초구",
//                        "cut_address": "서울 서초구 방배2동"
//            },
//            "legal_address": {
//                "address": "서울특별시 서초구 방배동",
//                        "admcode": "1165010100",
//                        "address_category3": "방배동",
//                        "address_category4": "",
//                        "jibun": "504-1",
//                        "address_category1": "서울특별시",
//                        "address_category2": "서초구",
//                        "cut_address": "서울 서초구 방배동"
//            }
//        }
//        }
    }
}
