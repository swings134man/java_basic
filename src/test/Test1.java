package test;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("This is Test Class");


        String str = "00, 01, 02, 03";

        String[] arr = str.split(", ");
//        for (String s : arr) {
//            System.out.println("s = " + s);
//        }



        // target이 week 라면
        String target = "month";
        // week - (월 ~ 금) 까지의 날짜 출력, 오늘 기준 저번주 월~금 날짜 출력
        // FIXME: 각요일 별 결과가 달라짐.......
        // 1. 현재 날짜 구하기
        LocalDate today = LocalDate.now();
        // 저번 주의 월요일을 구합니다.
//        LocalDate lastMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).minusWeeks(1);
        LocalDate lastMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).minusWeeks(1); // 화요일 현재 잘됨?
//        LocalDate lastMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate lastSunday = lastMonday.plusDays(6);


        System.out.println("mon" + lastMonday);
        System.out.println("sun" + lastSunday);




        System.out.println("=====================================");
        // month - 매월 1 ~ 월말 계산 (동적으로 해당 월)
        // 1. 현재 월 구하기
        LocalDate current = LocalDate.now();
        // 2. 현재 월의 1일 구하기
        LocalDate firstDay = current.withDayOfMonth(1);
        // 3. 현재 월의 마지막 날 구하기
        LocalDate lastDay = current.withDayOfMonth(current.lengthOfMonth());
        // 4. 포맷 변경 - yyyymmdd
        String firstDayStr = formattingDateToString(firstDay);
        String lastDayStr = formattingDateToString(lastDay);


        System.out.println("current = " + current);
        System.out.println("firstDay = " + firstDay);
        System.out.println("lastDay = " + lastDay);
        System.out.println("firstDayStr = " + firstDayStr);
        System.out.println("lastDayStr = " + lastDayStr);


        // 5. 1일 ~ 마지막 날까지의 날짜 출력 하여 조회
        // return map
        Map<String, String> map = new HashMap<>();
        map.put("start", firstDayStr);
        map.put("end", lastDayStr);

        System.out.println("map = " + map);

    }

    private static String formattingDateToString(LocalDate date) {
        return date.toString().replace("-", "");
    }
}
