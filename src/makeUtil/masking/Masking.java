package makeUtil.masking;

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
    public String nameKor(String name) {
        StringBuilder maskingName = new StringBuilder();

        if(name == null || name.isEmpty()){
            return "Name Value is Empty";
        }

        // 이름의 첫글자, 마지막 글자 제외 마스킹처리
        maskingName.append(name.charAt(0));

        for (int i = 1; i < name.length() -1; i++) {
            maskingName.append("*");
        }
        maskingName.append(name.substring(name.length() - 1));

        return maskingName.toString();
    }//nameKor



    // For Test
    public static void main(String[] args) {
        Masking masking = new Masking();
        System.out.println("Maksing Test");

        String res = masking.nameKor("김빛나라");
        String res2 = masking.nameKor("김이삭");

        System.out.println("res = " + res);
        System.out.println("res2 = " + res2);
    }
}
