package com.lucas.etc_methods.generics.wildcard;

/************
 * @info : Java Wild Card - 최상위 Class
 * @name : Company
 * @date : 2023/02/16 5:38 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public abstract class Company {
    static String IDENTITY = "Company";

    public void getToCompany() {
        System.out.println("This is called by Company");
    }

    public void getCompanyName() {};
}
