package com.share.datastructure.api.impl;

import com.share.datastructure.api.LinkedList;
import com.share.datastructure.api.Stack;

public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> data;

    public LinkedListStack() {
        this.data = new SLinkedList<>();
    }

    @Override
    public void push(T ele) {
        data.add(0, ele);
    }

    @Override
    public T pop() {
        return data.remove(0);
    }

    @Override
    public T peek() {
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
