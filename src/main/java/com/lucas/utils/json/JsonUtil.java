package com.lucas.utils.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtil {

    public JsonUtil() {
    }

    /**
     * Json To Map
     *
     * @param jsonString:String Type
     * @return Map<String, Object>
     */
    public Map<String, Object> jsonToMap(String jsonString) {
        Map<String, Object> map = new HashMap<>();

        // Find The Pattern
        Pattern pattern = Pattern.compile("\"(.*?)\"\\s*:\\s*(\\{.*?\\}|\\[.*?\\]|\".*?\"|\\d+\\.?\\d*|\\w+|true|false|null)");
        Matcher matcher = pattern.matcher(jsonString);

        while(matcher.find()){
            String key = matcher.group(1);
            String value = matcher.group(2);
            map.put(key, value);
        }

        return map;
    }


    /**
     * Make String Type Of Json To Map, If Json Has Array Type, Make List Type Of Map
     * Using Pattern, Matcher
     * This Pattern Is Not Perfect, But It Works
     * And It is just Find '{}' Type Of Json, and Make Map
     * @param jsonString
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> jsonToMapV2(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\{.*?\\}");
        Matcher matcher = pattern.matcher(jsonString);

        while (matcher.find()) {
            String jsonItem = matcher.group();
            list.add(jsonToMap(jsonItem));
        }

        return list;
    }


}
