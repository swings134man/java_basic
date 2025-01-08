package com.lucas.etc_methods.generics.wildcard;

/************
 * @info : Java Wild Card - Company Extends Class
 * @name : Hyundai
 * @date : 2023/02/16 5:42 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class Hyundai extends Company{

    private static final String NAME = "Hyundai";

    @Override
    public void getToCompany() {
        super.getToCompany();
    }

    @Override
    public void getCompanyName() {
        System.out.println("Company name is : " + NAME);
    }
}
