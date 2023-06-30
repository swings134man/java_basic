package java8InAction.basic_step_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/************
 * @info : 1.2.2 코드넘겨주기: 예제
 * @name : CodeThorwing
 * @date : 2023/06/30 10:16 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class CodeThorwing {

    // Class
    static ExamData data = new ExamData();

    /**
     * Filtering 예시1번
     */
   public static void filterOne() {
       List<String> resultList = new ArrayList<>();
       List<String> colorList = data.getColor();

       for(String color : colorList) {
           if(color.equals("red")) {
               resultList.add(color);
           }
       }
   }//filterOne()

    /**
     * Filtering 예시2번
     */
    public static void filterTwo() {
        List<String> resultList = new ArrayList<>();
        List<String> color = data.getColor();


    }//filterTwo

    // Red Exist Check
    public static boolean isRed(String data) {
        return data.equals("red");
    }

    // Predicate란? : 인수로 값을 받아서 true, false를 반환하는 함수형 인터페이스
    public interface Predicate<T> {
        boolean test(T t);
    }

    // Predicate 인터페이스를 이용한 필터링
    public static List<String> filterdColor(List<String> colorList, Predicate<String> p) {
        List<String> result = new ArrayList<>();
        for(String color : colorList) {
            if(p.test(color)) {
                result.add(color);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = filterdColor(data.getColor(), CodeThorwing::isRed);
        System.out.println("Arrays.toString = " + Arrays.toString(strings.toArray()));
    }
}//class

class ExamData {

    private List<String> colors;

    public ExamData() {
//        this.colors = new ArrayList<>("red", "blue", "green");
        this.colors = new ArrayList<>();
        this.colors.add("red");
        this.colors.add("blue");
        this.colors.add("green");
    }

    // get color List
    public List<String> getColor() {
        return this.colors;
    }
}