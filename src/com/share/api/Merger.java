package com.share.api;

public interface Merger<T> {
    T merge(T a, T b);
}
