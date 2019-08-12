package com.share.api.impl;

import com.share.api.Array;
import com.share.api.Heap;
import javafx.scene.Parent;

public class MinHeap<T extends Comparable<T>> implements Heap<T> {
    private Array<T> tArray;

    public MinHeap() {
        this.tArray = new DynamicArray<>();
    }

    public MinHeap(int capacity) {
        this.tArray = new DynamicArray<>(capacity);
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
        siftUp(getSize());
    }

    @Override
    public T pop() {
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

    private void siftUp(int index) {
        T val = tArray.get(index);
        for (int i = index; i >= 0; i = getParent(i)) {
            if(val.compareTo(tArray.get(getParent(i))) < 0){
                tArray.set(i,tArray.get(getParent(i)));
            }
        }
    }

    private void siftDown(int index) {
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }
}
