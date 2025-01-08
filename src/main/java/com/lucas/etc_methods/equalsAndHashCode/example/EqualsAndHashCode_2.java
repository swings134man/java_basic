package com.lucas.etc_methods.equalsAndHashCode.example;

/************
 * @info : Equals And HashCode Main 2
 * @name : EqualsAndHashCode_2
 * @date : 2023/02/11 5:42 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class EqualsAndHashCode_2 {

    public static void main(String[] args) throws CloneNotSupportedException {

        //1
        Person p = new Person();
        p.setName("kang");
        p.setLocation("seoul");

        //2
        Person p2 = new Person();
        p2.setName("kang");
        p2.setLocation("busan");

        System.out.println("p1, p2 is Equals? "+ p.equals(p2));
        System.out.println("p1 hash " + p.hashCode() + " p2 hash: " + p2.hashCode());
        if(p.hashCode() == p2.hashCode()) {
            System.out.println("same Hash is: " + p.hashCode());
        }

        // 3 - clone
        p2.setName("kim");
        Person p3 = (Person) p2.clone();
        if(p2.equals(p3)) {
            System.out.println("p2, p3 is equals");
            System.out.println("each hash " + "p2: " + p2.hashCode() + " p3: " + p3.hashCode());
        }
    }
}
