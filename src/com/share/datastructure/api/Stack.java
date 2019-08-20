package com.share.datastructure.api;

public interface Stack<T> {
    void push(T ele);
    T pop();
    T peek();
    int getSize();
    boolean isEmpty();
}
