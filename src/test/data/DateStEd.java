package test.data;

import java.util.HashMap;
import java.util.Map;

/************
 * @info : Java - Date 조작 관련
 * @name : DateStEd
 * @date : 2023/05/16 9:39 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Front 에서 년,월 (yyyy-MM) 으로 넘어온다면? 즉 한달단위의 검색을 원한다면? 서버에서 어떻게 처리할 것 인가?
 ************/
public class DateStEd {

    public String dateFunc(Map<String, Object> map) {
        // dayJs 의 경우 int Type 으로 넘어온다.
        // ex) 2023(year), 5(month)

        /**
         * 1번 예제. Mapper(MyBatis) 에서 String 으로 date 를 select 할 경우
         */
        StringBuilder sb = new StringBuilder();

        String rYear = String.valueOf(map.get("year"));
        String rMonth = String.valueOf(map.get("month"));

        sb.append(rYear).append("-");
        String res = ((int)map.get("month") < 10) ? String.valueOf(sb.append("0").append(rMonth)) : String.valueOf(sb.append(rMonth));

        return sb.toString();
    }


    public Map<String, Object> fullDate(Map<String, Object> map) {
        /**
         * 2번 예제.
         * 조회할 달 선택시 조회 조건 로직
         * -> 3월 ? start(2023-03-01 00:00:00.000) -> end(2023-04-01 00:00:00.000)
         */

        StringBuilder sb = new StringBuilder();
        String startDate = null;
        String endDate = null;

        String rYear = String.valueOf(map.get("year"));
        String rMonth = String.valueOf(map.get("month"));
        String anotherForm = "-01 00:00:00.000";

        sb.append(rYear).append("-");
        String res = ((int) map.get("month") < 10) ? String.valueOf(sb.append("0").append(rMonth).append(anotherForm)) : String.valueOf(sb.append(rMonth).append(anotherForm));

        startDate = sb.toString();
        map.put("start", startDate);
        sb.setLength(0); // StringBuilder 의 효율적인 초기화 방법.

        Map<String, Object> result = new HashMap<>();

        // sb.append(edMonthSt.length() == 1 ? "0" + edMonthSt + dayTime : edMonthSt + dayTime); -> Another code (2023.05.17)
        
        // 종료 날짜 format
        int getMapMonth = (int) map.get("month") + 1;
        sb.append(rYear).append("-");
        String res2 = (getMapMonth < 10) ? String.valueOf(sb.append("0").append(getMapMonth).append(anotherForm)) : String.valueOf(sb.append(getMapMonth).append(anotherForm));
        endDate = sb.toString();
        map.put("end", endDate);

        return map;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("year", 2023);
        map.put("month", 11);

        DateStEd dse = new DateStEd();
        // 2023-05 date 조회 포맷 만드는
        String s = dse.dateFunc(map);
        System.out.println("s = " + s);

        // 한달 조회시, 시작, 끝 date 포맷 및 파라미터 생성.
        Map<String, Object> resMap = dse.fullDate(map);
        System.out.println("start = " + resMap.get("start"));
        System.out.println("end = " + resMap.get("end"));
    }
}
