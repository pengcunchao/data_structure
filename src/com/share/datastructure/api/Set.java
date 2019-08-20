package com.share.datastructure.api;

public interface Set<T> {
    void add(T ele);
    void remove(T ele);
    boolean contains(T ele);
    int getSize();
    boolean isEmpty();
}
