package com.share.api;

public interface Stack<T> {
    void push(T ele);
    T pop();
    T peek();
    int getSize();
    boolean isEmpty();
}
