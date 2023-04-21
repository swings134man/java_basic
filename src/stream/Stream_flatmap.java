package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/************
 * @info : Java Stream flatmap()
 * @name : Stream_flatmap
 * @date : 2023/04/21 11:02 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Stream_flatmap {

    /**
     * map 은 스트림 내부의 요소를 하나씩 전부 탐색 하여 -> 최종연산에서 지정한 형식으로 반환 해주는 Method
     *
     * - flatMap 이란?
     *   -> flatMap()은 Stream 요소를 다른 요소로 변환하고 이를 하나의 스트림으로 평면화하는 데 사용됩니다.
     *      flatMap()은 각 요소를 처리하여 새로운 Stream을 생성하고, 그 결과를 하나의 Stream으로 평면화합니다.
     *      -> 스트림의 평면화, 즉 한줄로 데이터를 표헌 할 수 있게 하는것
     *
     *      EX) ["abc", "def"] 2개의 리스트가 있을때 -> ['a','b','c','d','e','f'] 모든 단어를 split 후 한줄로 만들기
     *      -> map(data -> data.split("")).collect(Collectors.toList()); 한다면 -> [["a","b","c"], ["..."]] 형태가 나오게 됨.
     */

    public static void main(String[] args) {
        List<String> testData = new ArrayList<>();
        testData.add("abc");
        testData.add("def");

        // 일반적인 map
        List<String[]> defaultMap = testData.stream().
                map(data -> data.split(""))
                .collect(Collectors.toList());

        defaultMap.forEach(data -> System.out.print(String.join(",", data))); // [a,b,c], [d,e,f]

        System.out.println();

        // flatmap
        List<String> usingFlat = testData.stream().map(data -> data.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("usingFlat = " + usingFlat); // [a,b,c,d,e,f]
    }

}
