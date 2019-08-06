package com.share.api;

public interface Queue<T> {
    void enQueue(T ele);
    T deQueue();
    T getFront();
    int getSize();
    boolean isEmpty();
}
