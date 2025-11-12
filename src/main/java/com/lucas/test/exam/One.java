package com.lucas.test.exam;

public class One {
    static private One instance = null;
    private int count = 0;

    static public One get(int x) {
        if(instance == null) instance = new One();

        instance.count += x;

        return instance;
    }

    public void count() {count ++;}
    public int getCount() {return instance.count;}
}


