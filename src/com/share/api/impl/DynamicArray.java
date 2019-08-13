package com.share.api.impl;

import com.share.api.Array;

public class DynamicArray<T> implements Array<T> {
    private static final int DEFAULT_SIZE = 16;
    private T[] data;
    private int size;

    public DynamicArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getCapacity() {
        return data.length;
    }

    @Override
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of bound!");
        }

        if (size == getCapacity()) {
            resize(this.data.length * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        data = newData;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        return data[index];
    }

    @Override
    public int removeElement(T ele) {
        for (int i = 0; i < size; i++) {
            if (ele.equals(data[i])) {
                remove(i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (isEmpty()) {
            throw new IllegalOperationException("Cannot remove element from empty array!");
        }

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        T result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        if (this.size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    @Override
    public T find(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        return data[index];
    }

    @Override
    public int findElement(T ele) {
        for (int i = 0; i < size; i++) {
            if (ele.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, T ele) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        data[index] = ele;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T ele) {
        for (int i = 0; i < this.size; i++) {
            if (ele.equals(this.data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void swap(int a, int b) {
        T temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
