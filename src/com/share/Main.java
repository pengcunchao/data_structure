package com.share;

import com.share.api.Array;
import com.share.api.impl.StaticArray;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new StaticArray<>();
        for (int i =0;i<10;i++){
            array.add(i,i);
        }
        System.out.println(array.get(6));
    }
}
