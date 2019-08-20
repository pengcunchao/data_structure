package com.share.datastructure.api;

public interface UnionFind {
    boolean isConnected(int p, int q);
    void union(int p, int q);
    int getSize();
}
