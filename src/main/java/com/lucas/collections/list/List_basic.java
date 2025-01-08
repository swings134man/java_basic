package com.lucas.collections.list;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/************
 * @info : Java - List 기본.
 * @name : List_basic
 * @date : 2023/02/02 1:18 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Java List Collection
 *
 * - Java List 에는 3종류가 존재한다. ArrayList, LinkedList, Vector
 * 1. 순서가 존재하고, 데이터의 중복 또한 허용한다.
 *
 ************/
public class List_basic {

    public static void main(String[] args) {
//        array_list();
        linked_list();
    } //main

    // ArrayList
    public static void array_list() {
        /*
            - ArrayList
            1. 중복 허용.
            2. 순서 존재.
            3. 데이터를 중간에 삽입, 혹은 삭제가 빈번한 경우 LinkedList가 더 효율적.
         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list); //[1, 2, 3, 4, 5]
        System.out.println("get: " +list.get(3)); // 3
        System.out.println("list size: " + list.size());
        System.out.println("----------------------------------");

        list.remove(2); //int 3 삭제. 0부터 시작.

        for (Integer forList: list) {
            System.out.println(forList);
        }

    }// ArrayList

    // LinkedList
    public static void linked_list() {
        /*
            - Linked List
            1. 각 노드마다 연결정보에 대한 데이터가 존재.
            2. 중간에 데이터 삽입, 삭제 하는 경우 ArrayList 보다 효율이 좋음.
            3. 단 검색시 순차 접근만이 가능하기 때문에, 자료 검색으로는 성능이 좋지않음.
         */
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        System.out.println("get: " + list.get(1)); //b
        System.out.println("list size: "+ list.size()); //5
        System.out.println("----------------------------------");

        list.add(2, "g"); //index 2번 위치에 데이터 삽입.
        for (String forList: list) {
            System.out.println(forList);
        }

    }


}//class
