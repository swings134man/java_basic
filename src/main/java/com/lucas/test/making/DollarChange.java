package com.lucas.test.making;

import java.text.DecimalFormat;
import java.util.*;

/************
 * @info : Dollar Change - 서양권 단위(milion, k) 단위로 달러 -> 원화 계산
 * @name : DollarChange
 * @date : 2023/02/28 1:51 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 달러 -> 원화로 변환
 *
 * - Dollar : 1$ = 1,300 won
 * - Won = 1,000 won = 0.7$
 *
 * - Dollar = number * 1,000;
 * - milion = 백만
 *
 * - 예제 1.5 milion(150만 달러) 일 경우 -> (1,500,000 $ * 1,300)
 *
 * - 입력 예시 : 1.5 milion
 ************/
public class DollarChange {

    DecimalFormat df = new DecimalFormat("###,###.##"); // number format

    /*
        숫자 포맷 변경
        input : Integer
        return : String
        param : Integer
     */
    private String numberFormat(Double number) {
        return df.format(number);
    }

    /*
        Dollar to Won 변환.
     */
    private String toWon(Map<String, String> map) {
        String result = "";

        String unit = map.get("unit");
        if(unit.equals("milion")) {
            result = milionToWon(map.get("value"));
        }else {
            result = kToWon(map.get("value"));
        }

        return result;
    }

    // milion -> milion
    private String milionToWon(String value) {
        double v = Double.parseDouble(value);
        double dollar = v * 1000000;
        String dollarFormat = numberFormat(dollar);

        double res = (v * 1000000) * 1300;
        return dollarFormat+ "$ = " + numberFormat(res) + " KRW";
    }

    // k -> won
    // 10 k = 10,000 : 1k = 1000
    private String kToWon(String value) {
        double v = Double.parseDouble(value);
        double dollar = v * 1000;
        String dollarFormat = numberFormat(dollar);

        double res = (v * 1000) * 1300;
        return dollarFormat+ "$ = " + numberFormat(res) + " KRW";
    }


    public static void main(String[] args) {
        DollarChange dc = new DollarChange();
        Map<String, String> map = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("입력하세요 예시 1.5 milion or 1.3 k) 현재 환율 : 1$ - 1300 KRW");
            System.out.print("---> ");
            String input = sc.nextLine();

            // 종료 시그널
            if(input.equals("exit")) {
                break;
            }

            String[] arr = input.split(" ");

            map.put("value", arr[0]);
            map.put("unit", arr[1]); // 단위 : milion(Lower), k(Lower)

            String s = dc.toWon(map);
            System.out.println("환전 결과 = " + s);
            System.out.println();
        }
        System.out.println("종료 되었습니다.");
    }
}
