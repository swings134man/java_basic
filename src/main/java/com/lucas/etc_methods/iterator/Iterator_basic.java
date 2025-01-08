package com.lucas.etc_methods.iterator;

import java.util.*;

/************
 * @info : Java - Iterator 기본1
 * @name : Iterator_basic
 * @date : 2023/03/09 6:17 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java Iterator
 *
 * - Iterator(반복자) :  배열이나, 그와 유사한 자류구조의 내부요소를 순회하는 객체. (특히 List)
 *
 * -- for(i, each), while문을 사용하면 되지 않나?
 *      -> List에는 index가 존재하지만, Set은 순서가 존재하지 않음. -> for-each 반복문이 할 수없는일을 수행함.
 *          --> **중요) for-each문 경우는 자료구조를 순회하다가, 값을 수정, 삭제하는 코드를 넣으면 ConcurrentModificationException 발생.
 *      -> 또한 Linked List를 사용하게 된다면 모든 요소를 탐색하기 때문에 성능저하.
 *
 *
 * - 장점
 *      1. 컬렉션에서 요소를 제어하는 기능.
 *      2. next(), previous()를 사용해서 앞뒤 요소로 이동 가능.
 *      3. hasNext()를 사용해서 더 많은 요소가 존재하는지 확인 가능.
 *      4. Collection 자체에 iterator 구현 기능이 존재.
 *
 ************/
public class Iterator_basic {
    public static void main(String[] args) {

        /*
            Collection : Array List
         */
        ArrayList<String> cars = new ArrayList<>();
        cars.add("현대");
        cars.add("기아");
        cars.add("벤츠");
        cars.add("람보르기니");
        cars.add("랜드로버");

        // Iterator 획득.
        Iterator<String> iteratorCars = cars.iterator();
        // while ->  현대 기아 벤츠 람보르기니 랜드로버
        System.out.println("------------ Array List ------------");
        while (iteratorCars.hasNext()) {
            System.out.print(iteratorCars.next()+ " ");
        }
        System.out.println();

        // 값 변경 - ArrayList 원본 데이터 자체가 변경된다.
        ListIterator<String> listIterator = cars.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            listIterator.set("my_" + next);
        }
        System.out.println("값 변경 후 list =" + cars);


        System.out.println();
        System.out.println("------------ set ------------");
        /*
            Collection : Set
         */
        Set<String> carsSet = new HashSet<>();
        carsSet.add("현대");
        carsSet.add("기아");
        carsSet.add("벤츠");
        carsSet.add("람보르기니");
        carsSet.add("랜드로버");

        Iterator<String> iteratorSet = carsSet.iterator();
        // Set - while 순서 보장 X
        while (iteratorSet.hasNext()) {
            System.out.println("Set(Cars) res=" + iteratorSet.next());
        }

        System.out.println("------------ Map ------------");
        /*
            Collection : Map
         */
        Map<String, String> map = new HashMap<>();
        map.put("h", "현대");
        map.put("k", "기아");
        map.put("b", "벤츠");
        map.put("l", "람보르기니");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println("Map res: " + iterator.next());
        }

        // 값변경.
        System.out.println("------------ Map Value Change ------------");
        Iterator<Map.Entry<String, String>> iteratorMap2 = map.entrySet().iterator();
        while (iteratorMap2.hasNext()) {
            // key = l , value = 람보르기니 -> 랜드로버 변경
            Map.Entry<String, String> next = iteratorMap2.next();
            if(next.getKey().equals("l") && next.getValue().equals("람보르기니")){
                next.setValue("랜드로버");
            }
            System.out.println("map 값변경 : " + next.getKey() + "=" + next.getValue());
        }


    }//main
}//class
