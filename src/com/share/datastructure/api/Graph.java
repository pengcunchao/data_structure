package com.share.datastructure.api;

public interface Graph<T> {
    void addEdge(int n,int m, int weight);

    int getWeight(int n, int m);
}
