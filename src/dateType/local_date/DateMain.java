package dateType.local_date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/************
 * @info : Java LocalDate Type Example
 * @name : DateMain
 * @date : 12/5/23 10:21 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class DateMain {

    /**
     * Java에는 날짜를 표현하는 여러가지 방법이 존재한다.
     * DB 와 연동시에는 DB의 날짜 타입에 맞춰서 사용해야한다.
     * 제일 많이 사용하는 5가지 타입에 대해서 기술한다.
     *
     * - java.util.Date: 날짜와 시간을 모두 표현할 수 있지만, 날짜 연산에는 적합하지 않다.
     * - java.time.instant: 날짜와 시간을 모두 표현할 수 있고, 날짜 연산에도 적합하다.
     * - java.time.LocalDate: 날짜만 표현할 수 있고, 날짜 연산에도 적합하다.
     * - java.time.LocalDateTime: 날짜와 시간을 모두 표현할 수 있고, 날짜 연산에도 적합하다.
     * - java.time.LocalTime: 시간만 표현할 수 있고, 날짜 연산에도 적합하다.
     */
    public static void main(String[] args) {
//        instantType();
//        localDateTime();
        localDate();
    }

    // java.util.Date
    private static void date() {
        Date date = new Date();

        long time = date.getTime();// 1638721265
    }

    // java.time.Instant
    private static void instantType() {
        /**
         * Instant 는 기준시 UTC(협정세계시)를 사용한다.
         * DB에 저장할 때는 Instant를 사용하고, 화면에 표시할 때는 LocalDateTime을 사용한다.
         * Instant는 한국 기준 시간보다 9시간 빠르다. 즉 UTC+9 이다.
         *
         * immutable 하고, thread-safe 하다.
         *
         *  MySQL : DATETIME || TIMESTAMP 사용가능
         *  Oracle : TIMESTAMP 사용가능
         */

        // 정의 및 설정
        Instant instant = Instant.now();

        Instant korTime = instant.plusSeconds(32400); // 9시간 더하기
        Instant korTimeSet = instant.atZone(ZoneOffset.ofHours(9)).toInstant(); // 9시간 더하기
        Instant seoul = instant.atZone(ZoneId.of("Asia/Seoul")).toInstant(); // 서울 시간 설정.

        System.out.println("instant now() = " + instant); // instant = 2021-12-05T13:21:05.000Z
        System.out.println("korTime = " + korTime); // korTime = 2021-12-05T22:21:05.000Z

        // 추가로 날짜 계산또한 용이함.
        Instant yesterdayForNow = instant.minus(1, ChronoUnit.DAYS); // Day -1
        Instant tomorrowForNow = instant.plus(24, ChronoUnit.HOURS); // Day +1 결국 1일 더하기

        // 비교
        // 어제와 오늘 시간차이
        long diff = yesterdayForNow.until(instant, ChronoUnit.HOURS); // 24
        long diffMinute = yesterdayForNow.until(instant, ChronoUnit.MINUTES); // 1440

        // 문자열
        String instantToStr = instant.toString(); // 2021-12-05T13:21:05Z

        // LocalDateTime 으로 변환
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("localDateTime = " + localDateTime); // 2023-12-05T22:48:10.002888
    }

    // LocalDateTime
    private static void localDateTime() {
        /**
         * LocalDateTime 은 현재 로컬 시간에 맞춰서 시간을 표현함.
         *
         * MySQL : DATETIME || TIMESTAMP 사용가능
         * Oracle : TIMESTAMP 사용가능
         *
         */

        // 정의 및 설정
        LocalDateTime ldt = LocalDateTime.now(); //2023-12-05T22:52:31.083586
        System.out.println("ldt = " + ldt);

        String format1 = ldt.format(DateTimeFormatter.ofPattern("yyyyMMdd")); // 20231205 - format 설정시 String 으로 반환
        System.out.println("format1 = " + format1);

        // String To LocalDateTime
        // LocalDateTime.parse() 는 ISO 8601 형식을 맞춰줘야 함. -> yyyy-MM-ddTHH:mm:ss
        String str = "2023-12-05T12:01:01";
        LocalDateTime parse = LocalDateTime.parse(str);
        System.out.println("parse = " + parse);
        System.out.println("parse Type = " + parse.getClass().getTypeName()); // java.time.LocalDateTime
    }

    // LocalDate
    public static void localDate() {
        /**
         * LocalDate 는 현재 로컬 시간에 맞춰서 날짜를 표현함.
         *
         * MySQL : DATE 사용가능
         * Oracle : DATE 사용가능
         *
         */

        // 정의 및 설정
        LocalDate now = LocalDate.now(); // 2023-12-05
        System.out.println("now = " + now);

        // String To LocalDate
        String date = "20231201";
        LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd")); // 2023-12-01
        System.out.println("parse = " + parse);

        // 만약 String To LocalDate 로 변환 후 다시 포맷을 걸려면?
        String yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd").format(parse);// 20231201
    }

}//class
