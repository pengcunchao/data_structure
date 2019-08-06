package com.share;

import com.share.api.Array;
import com.share.api.impl.DynamicArray;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new DynamicArray<>();
        for (int i =0;i<10;i++){
            array.add(i,i);
        }
        System.out.println(array.get(6));
    }
}
