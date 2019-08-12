package com.share.api;

public interface Heap<T extends Comparable<T>> {
    int getSize();
    boolean isEmpty();
    void push(T ele);
    T pop();
    T peek();
}
