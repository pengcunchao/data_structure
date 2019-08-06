package com.share.api.impl;

import com.share.api.Queue;

public class LoopQueue<T> implements Queue<T> {
    private static final int DEFAULT = 10;
    private T[] data;
    private int head, tail;

    public LoopQueue() {
        this(DEFAULT);
    }

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
    }

    @Override
    public void enQueue(T ele) {
        if (getSize() == getCapacity()) {
            resize(2 * getCapacity());
        }

        data[tail] = ele;
        tail = (tail + 1) % data.length;
    }

    private int getCapacity(){
        return data.length - 1;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(head + i) % data.length];
        }
        head = 0;
        tail = getSize();

        data = newData;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T result = data[head];
        head = (head + 1) % data.length;

        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public T getFront() {
        return isEmpty() ? null : data[head];
    }

    @Override
    public int getSize() {
        return (tail - head) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
