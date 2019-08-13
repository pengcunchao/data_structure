package com.share.api.impl;

public class SegmentTreeNode<T> {
    private int head;
    private int tail;
    private T val;
    private SegmentTreeNode<T> leftChild;
    private SegmentTreeNode<T> rightChild;

    public SegmentTreeNode(int head, int tail, T val) {
        this.head = head;
        this.tail = tail;
        this.val = val;
    }

    public SegmentTreeNode(int head, int tail, T val, SegmentTreeNode<T> leftChild, SegmentTreeNode<T> rightChild) {
        this.head = head;
        this.tail = tail;
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public SegmentTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(SegmentTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public SegmentTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(SegmentTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
