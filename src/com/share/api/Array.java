package com.share.api;

public interface Array<T> {
    int getSize();
    int getCapacity();
    void add(int index, T ele);
    T get(int index);
    int removeElement(T ele);
    T remove(int index);
    T find(int index);
    int findElement(T ele);
    void set(int index, T ele);
    boolean isEmpty();
}
