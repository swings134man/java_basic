package com.lucas.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/************
 * @info : Java - Stream Basic 2
 * @name : Stream_2
 * @date : 2023/04/11 11:52 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Stream_2 {
    public static void main(String[] args) {
        // int타입의 list Stream
        // reduce
        /*
         * 1. reduce 메서드는 엘리먼트를 비교하고 컬렉션에서 하나의 값으로 연산한다.
         */
        List<Integer> list1 = Arrays.asList(3,2,4,1,5); // list 생성
        int sumOfList = list1.stream().reduce(0, Integer::sum); // list의 값들의 합계.
        //integers.reduce(0, (a, b) -> a+b); // 해당 코드는 위의 코와 대치됨.
        System.out.println("Sum : " + sumOfList);

        // Max
        int maxOfList = list1.stream().reduce(0, Integer::max);
        System.out.println("Max : "+ maxOfList);

        // 2번 예제 - reduce(String 의 길이를 비교하여 가장 긴것을 String에 저장)
        List<String> namesOfReduce = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

        // 결과
        String longName = namesOfReduce.stream().reduce("juuun", (name1, name2) ->
                name1.length() >= name2.length() ? name1 : name2);
        int longNameCount = longName.length();
        System.out.println("Long Name is : " + longName + " -> " + longNameCount);


        // ------------------------------------------------
        // map
        /*
         * 1. map Method 는 입력 컬렉션을 출력 컬렉션으로 매핑하거나 변경시 유용함.
         */
        List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");
        // java 8 lambda
        names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);

        // Collectors. joining
        /*
         * 1. Collector 의 입력 요소를 단일 문자열로 연결한다.
         * 2. 요소 사이에 넣을 요소(delimiter), 문자열의 앞(prefix), 문자열의 뒤 (suffix)를 설정 가능
         * 	  -->> Collectors.joining(delimiter, prefix, suffix)
         *    -->>>> Collectors.joining(", ", "{", "}")
         *    ->result : {RED, BLUE, BLACK, GREEN}
         */
        List<String> joining1 = Arrays.asList("a","b","c","d","e");

        // 문자열로(String) 변환하고 요소 사이에 ", " 를 넣는다. 사이에 넣는것임으로 마지막은 출력x
        System.out.println("joining : " +
                joining1.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))

        );

//		위의 code는 아래와 같이 사용했었음.
//		for(string s : list) sb.append(s).append(", ");
//		System.out.println(sb.subString(0,sb.length()-2).toString());

        // ------------------------------------------------
        // filter
        /*
         *  1. filter는 컬렉션을 조건에 의한 선택시 유용하다.
         *  2. filter 메서드는 boolean 결과를 리턴하는 람다 표현식이 필요하다.
         *  3. 아래의 예제는 -> 결과를 List 에 재할당을 기준으로 한다.
         */
        List<String> names2 = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");
        // result
        List<String> resultFilter = names2.stream().filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("Filter Reseult : " + resultFilter);

        // ------------------------------------------------
        // sort
        /*
         * 1. sort메서드는 정렬을 함.
         */
        List<String> alpha = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

        // result -> asc(오름차순 a ~ )
        List<String> resultAlpha1 = alpha.stream().sorted().collect(Collectors.toList()); //[Go, Groovy, Java, Python, Scala, Swift]
        //2 -> 역순 desc(내림차순 z ~ )
        List<String> resultAlpha2 = alpha.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()); //[Swift, Scala, Python, Java, Groovy, Go]

        System.out.println("오름차순 : " + resultAlpha1);
        System.out.println("내림차순 : " + resultAlpha2);
    }
}
