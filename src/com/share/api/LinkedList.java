package com.share.api;

public interface LinkedList<T> {
    int getSize();
    boolean isEmpty();
    void add(int index, T ele);
    T get(int index);
    void set(int index, T ele);
    boolean contains(T ele);
    T remove(int index);
    boolean removeElement(T ele);
}
