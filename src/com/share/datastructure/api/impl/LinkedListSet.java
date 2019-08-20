package com.share.datastructure.api.impl;

import com.share.datastructure.api.LinkedList;
import com.share.datastructure.api.Set;

public class LinkedListSet<T> implements Set<T> {
    private LinkedList<T> data;

    public LinkedListSet(LinkedList<T> data) {
        this.data = data;
    }

    @Override
    public void add(T ele) {
        if(!data.contains(ele)){
            data.add(0,ele);
        }
    }

    @Override
    public void remove(T ele) {
        data.removeElement(ele);

    }

    @Override
    public boolean contains(T ele) {
        return data.contains(ele);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
