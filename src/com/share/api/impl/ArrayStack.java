package com.share.api.impl;

import com.share.api.Array;
import com.share.api.Stack;

public class ArrayStack<T> implements Stack<T> {
    private Array<T> data;

    public ArrayStack() {
        this.data = new DynamicArray<>();
    }

    public ArrayStack(int capacity) {
        this.data = new DynamicArray<>(capacity);
    }

    @Override
    public void push(T ele) {
        data.add(data.getSize(), ele);
    }

    @Override
    public T pop() {
        return data.remove(data.getSize() - 1);
    }

    @Override
    public T peek() {
        return data.get(data.getSize() - 1);
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
