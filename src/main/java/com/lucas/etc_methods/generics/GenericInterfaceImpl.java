package com.lucas.etc_methods.generics;


/************
 * @info : Generic Interface - Impl
 * @name : GenericInterfaceImpl
 * @date : 2023/02/12 2:04 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Interface에 정의한 제네릭 타입으로 impl 하게 된다면, Return Type 들이 지정한대로 정해진다.
 *
 *
 ************/
public class GenericInterfaceImpl implements GenericInterface<String, Integer>{

    public String name = NAME;

    // impl Only
    private String typeOfT = "T is String";
    private Integer elementOfE = 100;

    @Override
    public String getType(String type) {
        return type;
    }

    @Override
    public Integer getElement(Integer element) {
        return element;
    }

    @Override
    public String getT() {
        return typeOfT;
    }

    @Override
    public Integer getE() {
        return elementOfE;
    }
}// impl


class GenericImplMain {
    public static void main(String[] args) {
        GenericInterfaceImpl impl = new GenericInterfaceImpl(); //이미 impl Class에서 제네릭 타입이 명시되어 있기 때문에 객체 생성시 명시 X
        String type = impl.getType("this is T");
        Integer element = impl.getElement(10);

        System.out.println("type : " + type);
        System.out.println("element : " + element);

        // getT, getE
        System.out.println("getT : " + impl.getT());
        System.out.println("getE : " + impl.getE());

        // Interface Field
        System.out.println("interface field: " + impl.name);

    }
}
