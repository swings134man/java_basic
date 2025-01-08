package com.lucas.etc_methods.generics.wildcard;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/************
 * @info : Java Generic Wild Card - main
 * @name : WildCard_main
 * @date : 2023/02/14 2:50 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class WildCard_main {


    public static void main(String[] args) throws Exception{
        // extedns
        List<? extends Company> objectsList = new ArrayList<Company>();
        List<? extends Company> hyundaiList = new ArrayList<Hyundai>();
//        List<? extends Company> kiaList = new ArrayList<Kia>();
//        List<? extends Company> kiaList2 = new ArrayList<>();


        // super
        List<? super Hyundai> hyundaiSuper = new ArrayList<Company>(); // Hyundai + Company + Object
        List<? super Hyundai> hyundaiSuper2 = new ArrayList<Hyundai>(); // Hyundai + Company + Object
//        List<? super Kia> kiaSuper = new ArrayList<Company>(); // kia + Company + Object


        // kia extends
        List<Kia> k = new ArrayList<>();
        k.add(new Kia());
        printList(k);



        // Hyundai super
        Hyundai h = new Hyundai(); // Hyundai 객체
        hyundaiSuper2.add(h);   // List add
        Hyundai hRes = (Hyundai) hyundaiSuper2.get(0);
        hRes.getCompanyName();

    }// main

    // Extends Methods
    public static void printList(List<? extends Company> list) throws Exception {
        System.out.println();

        for(Object ob : list) {
            System.out.println(ob.getClass().getName());

            // Kia Method - getCompanyName call
            if(ob.getClass().getName().equals("com.lucas.etc_methods.generics.wildcard.Kia")) {
                System.out.println("find class");
                Method getCompanyName = ob.getClass().getDeclaredMethod("getCompanyName");
                getCompanyName.invoke(ob);
            }


        }
    }// method
}
