package com.share.api.impl;

import com.share.api.Merger;
import com.share.api.SegmentTree;

public class TreeSegmentTree<T> implements SegmentTree<T> {
    private SegmentTreeNode<T> root;

    private T[] data;

    private Merger<T> merger;

    public TreeSegmentTree(T[] data, Merger<T> merger) {
        this.data = data;
        this.merger = merger;
        this.root = buildSegmentTree(data, 0, data.length - 1, merger);
    }

    private SegmentTreeNode<T> buildSegmentTree(T[] data, int start, int end, Merger<T> merger) {
        if (start == end) {
            return new SegmentTreeNode<>(start, end, data[start]);
        }

        int mid = start + (end - start) / 2;
        SegmentTreeNode<T> left = buildSegmentTree(data, start, mid, merger);
        SegmentTreeNode<T> right = buildSegmentTree(data, mid + 1, end, merger);
        return new SegmentTreeNode<>(start, end, merger.merge(left.getVal(), right.getVal()), left, right);
    }

    public SegmentTreeNode<T> getRoot() {
        return root;
    }

    public T query(int start, int end) {
        return query(root, start, end);
    }

    public void update(int index, T val) {
        data[index] = val;
        update(root, index, val);
    }

    private void update(SegmentTreeNode<T> node, int index, T val) {
        int head = node.getHead();
        int tail = node.getTail();

        if (index < head || index > tail) {
            throw new IllegalArgumentException("illegal argument");
        }

        if (node.getHead() == node.getTail() && node.getHead() == index) {
            data[index] = val;
            node.setVal(val);
            return;
        }

        int mid = head + (tail - head) / 2;
        if (index > mid) {
            update(node.getRightChild(), index, val);
        } else {
            update(node.getLeftChild(), index, val);
        }
        node.setVal(merger.merge(node.getLeftChild().getVal(), node.getRightChild().getVal()));
    }

    private T query(SegmentTreeNode<T> node, int start, int end) {
        int head = node.getHead();
        int tail = node.getTail();
        if (start < head || end > tail || start > end) {
            throw new IllegalArgumentException("illegal argument");
        }

        if (start == head && end == tail) {
            return node.getVal();
        }

        int mid = head + (tail - head) / 2;
        if (end <= mid) {
            return query(node.getLeftChild(), start, end);
        }
        if (start > mid) {
            return query(node.getRightChild(), start, end);
        }

        return merger.merge(query(node.getLeftChild(), start, mid), query(node.getRightChild(), mid + 1, end));
    }

    public T[] getData() {
        return data;
    }

    public void print() {
        print(root);
    }

    private void print(SegmentTreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getVal());
        print(node.getLeftChild());
        print(node.getRightChild());
    }
}
