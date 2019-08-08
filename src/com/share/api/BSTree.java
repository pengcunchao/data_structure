package com.share.api;

public interface BSTree<T extends Comparable<T>> {
    int getSize();
    boolean isEmpty();
    void add(T val);
    boolean contains(T val);
    void traverse();
    void remove(T val);
}
