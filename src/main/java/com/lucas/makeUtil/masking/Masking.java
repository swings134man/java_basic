package com.lucas.makeUtil.masking;

import com.lucas.config.annotation.TImerRunner;
import com.lucas.config.annotation.Timer;

import java.util.Map;

/************
 * @info : Java - Util Masking
 * @name : Masking
 * @date : 2023/05/09 9:38 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 마스킹(이름, 전화번호, 계좌번호, 등등) 처리 유틸
 ************/
public class Masking {

    public String keyWord;
    public String type;

    public Masking() {}

    public Masking(Map<String, String> param) {
        this.keyWord = param.get("keyWord");
        this.type = param.get("type");
    }


    /*
        한글 이름 마스킹 처리
     */
    @Timer(value = "Masking", status = "nameKor")
    public String nameKor(String name) {
        StringBuilder maskedName = new StringBuilder();

        if(name == null || name.isEmpty()){
            return "Name Value is Empty";
        }

        // 이름의 첫글자, 마지막 글자 제외 마스킹처리
        maskedName.append(name.charAt(0));

        for (int i = 1; i < name.length() -1; i++) {
            maskedName.append("*");
        }
        maskedName.append(name.substring(name.length() - 1));

        return maskedName.toString();
    }//nameKor

    /*
        전화 번호 마스킹
        핸드폰 - 11자리(344), 10자리(334, OLD)
     */
    public String phoneNumber(String number) {
        StringBuilder maskedNumber = new StringBuilder();

        if(number == null || number.isEmpty()) {return "Number Value Is Empty";}

        if(number.length() == 10){
            maskedNumber.append(number.substring(0, 3)).append("***");
            maskedNumber.append(number.substring(number.length() - 4, number.length()));

        }else if(number.length() == 11){
            maskedNumber.append(number.substring(0, 3)).append("****");
            maskedNumber.append(number.substring(number.length() - 4, number.length()));
        }else {
            maskedNumber.append("Invalid number of digits"); // 유효하지않은 자릿수.
        }

        return maskedNumber.toString();
    }

    /*
        TODO: 계좌번호의 경우 자릿수가 다를시 어떻게 마스킹 할지 설계 후 작성.
        계좌번호 마스킹
            - 은행별 계좌번호 자릿수 및 패턴 상이함.
            -> 11 ~ 13 자리 사이.
     */
    @Timer(value = "bankAccount", status = "Enabled")
    public String bankAccount(String account) {
        StringBuilder maskedAccount = new StringBuilder();
        String middleVal = "";

        // business
        if(account.isEmpty()) {return "Account Value Is Empty";}

        if(account.length() == 13){
            middleVal = account.substring(3, account.length() - 3);

            maskedAccount.append("***").append(middleVal).append("***");
        }else {
            return "해당 자릿수는 아직 제공하지 않습니다.";
        }


        return maskedAccount.toString();
    }

    // For Test
    public static void main(String[] args) {
        Masking masking = new Masking();

        // Annotation Process
        TImerRunner runner = new TImerRunner(masking);
        runner.withAnnotation();

        // Masking Test
        System.out.println("Maksing Test");

        //----------- Name Kor
        String res = masking.nameKor("김빛나라");
        String res2 = masking.nameKor("김이삭");

        System.out.println("res = " + res);
        System.out.println("res2 = " + res2);

        String numberRes = masking.phoneNumber("01012345678");
        String numberRes2 = masking.phoneNumber("0112345678");
        System.out.println("numberRes = " + numberRes);
        System.out.println("numberRes2 = " + numberRes2);

        //----------- Bank

        String bankRes1 = masking.bankAccount("1234567890123");
        System.out.println("bankRes1 = " + bankRes1);
    }
}
