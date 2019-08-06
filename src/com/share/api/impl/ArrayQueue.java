package com.share.api.impl;

import com.share.api.Array;
import com.share.api.Queue;

public class ArrayQueue<T> implements Queue<T> {
    private Array<T> data;

    public ArrayQueue() {
        this.data = new DynamicArray<>();
    }

    public ArrayQueue(int capacity) {
        this.data = new DynamicArray<>(capacity);
    }

    @Override
    public void enQueue(T ele) {
        data.add(getSize(),ele);
    }

    @Override
    public T deQueue() {
        return data.remove(0);
    }

    @Override
    public T getFront() {
        return data.get(0);
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
