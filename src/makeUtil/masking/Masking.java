package makeUtil.masking;

import config.annotation.Timer;

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
            -> 2023.05.10: 은행 종류 따지지않고, 앞 4자리, 뒤4자리 마스킹 예정
     */
    public String bankAccount(String account) {
        String maskedAccount = "";
        return maskedAccount;
    }

    // For Test
    public static void main(String[] args) {
        Masking masking = new Masking();
        System.out.println("Maksing Test");

        String res = masking.nameKor("김빛나라");
        String res2 = masking.nameKor("김이삭");

        System.out.println("res = " + res);
        System.out.println("res2 = " + res2);

        String numberRes = masking.phoneNumber("01012345678");
        String numberRes2 = masking.phoneNumber("0112345678");
        System.out.println("numberRes = " + numberRes);
        System.out.println("numberRes2 = " + numberRes2);

    }
}
