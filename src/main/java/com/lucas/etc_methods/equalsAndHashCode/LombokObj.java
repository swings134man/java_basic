package com.lucas.etc_methods.equalsAndHashCode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @package : com.lucas.etc_methods.equalsAndHashCode
 * @name : LombokObj.java
 * @date : 2025. 2. 11. 오후 10:00
 * @author : lucaskang(swings134man)
 * @Description: Equals And Hashcode Lombok Sample Class
**/
@Getter @Setter
@EqualsAndHashCode
public class LombokObj {
    private int age;
    private String name;
}
