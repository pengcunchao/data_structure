package com.share.api.impl;

import com.share.api.Array;
import com.share.api.Heap;

public class MinHeap<T extends Comparable<T>> implements Heap<T> {
    private Array<T> tArray;

    public MinHeap() {
        this.tArray = new DynamicArray<>();
    }

    public MinHeap(int capacity) {
        this.tArray = new DynamicArray<>(capacity);
    }


    public  static <T extends Comparable<T>> Heap<T> heapify(T[] data) {
        Array<T> tArray = new DynamicArray<>(data.length);
        for (int i = 0; i < data.length; i++) {
            tArray.add(i, data[i]);
        }
        MinHeap<T> minHeap = new MinHeap<>(tArray.getCapacity());
        minHeap.settArray(tArray);
        for (int i = minHeap.getParent(tArray.getSize() - 1); i >= 0; i--) {
            minHeap.siftDown(i);
        }
        return minHeap;

    }

    private void settArray(Array<T> tArray){
        this.tArray = tArray;
    }

    @Override
    public int getSize() {
        return tArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return tArray.isEmpty();
    }

    @Override
    public void push(T ele) {
        tArray.add(getSize(), ele);
        siftUp(getSize() - 1);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T ret = tArray.get(0);
        tArray.set(0, tArray.get(getSize() - 1));
        tArray.remove(getSize() - 1);
        siftDown(0);
        return ret;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : tArray.get(0);
    }

    @Override
    public T replace(T ele) {
        if (isEmpty()) {
            return null;
        }
        T ret = peek();
        tArray.set(0, ele);
        siftDown(0);
        return ret;
    }

    private void siftUp(int index) {
        T val = tArray.get(index);
        for (int i = index; i > 0; i = getParent(i)) {
            if(val.compareTo(tArray.get(getParent(i))) < 0){
                tArray.set(i,tArray.get(getParent(i)));
            } else {
                tArray.set(i, val);
                break;
            }
        }

        if (tArray.get(0).compareTo(val) > 0) {
            tArray.set(0, val);
        }
    }

    private void siftDown(int index) {
        int minChild = 0;
        for (int i = index; getLeftChild(i) < getSize() - 1; ) {
            minChild = getLeftChild(i);
            if (minChild + 1 < getSize()) {
                if (tArray.get(minChild).compareTo(tArray.get(minChild + 1)) > 0) {
                    minChild = minChild + 1;
                }
            }
            if (tArray.get(minChild).compareTo(tArray.get(i)) >= 0) {
                break;
            }
            tArray.swap(minChild, i);
            i = minChild;
        }
    }

    private int getParent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("illegal index");
        }
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

}
