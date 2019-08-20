package com.share.datastructure.api.impl;

import com.share.datastructure.api.BSTree;
import com.share.datastructure.api.Set;

public class TreeSet<T extends Comparable<T>> implements Set<T> {
    private BSTree<T> data;

    public TreeSet(BSTree<T> data) {
        this.data = data;
    }

    @Override
    public void add(T ele) {
        data.add(ele);
    }

    @Override
    public void remove(T ele) {
        data.remove(ele);
    }

    @Override
    public boolean contains(T ele) {
        return data.contains(ele);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
