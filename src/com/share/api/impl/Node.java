package com.share.api.impl;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data,null);
    }

    public Node() {
        this(null,null);
    }
}
