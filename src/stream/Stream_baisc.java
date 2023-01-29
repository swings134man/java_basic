package stream;


import java.util.*;
import java.util.stream.Collectors;

/************
 * @info : Java Stream Basic
 * @name : Stream_baisc
 * @date : 2023/01/29 6:56 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 *  - Stream 순서 : 전체 -> 맵핑 -> 필터링1 - > 필터링2 -> 결과만들기 -> 최종결과.
 ************/
public class Stream_baisc {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 3, 4, 5, 2);
        System.out.println(list);

        // list를 정렬하여 List에 재정의
        // - collect() stream 데이터를 변형, 처리 하여 원하는 자료형으로 변환.
        // ->> List, set 자료형으로 변환, joining, Sorting,
        List<Integer> result = list.stream().sorted().collect(Collectors.toList());
//        List<Integer> result = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); // desc
        System.out.println(result);

        /*
            List to Set
         */
        Set<Integer> set = new HashSet<>(result);
        System.out.println(set);

        /*
            Array to Set
         */
        Integer[] array1 = {1,3,2,4,5};
        Set<Integer> aToSet = Arrays.stream(array1).collect(Collectors.toSet());
        System.out.println(aToSet);




    }
}
