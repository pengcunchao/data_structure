package com.share.datastructure.api.impl;

import com.share.datastructure.api.Queue;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = new Node<>(null, null);
        this.tail = null;
        this.size = 0;
    }

    public LinkedListQueue(T ele) {
        this.tail = new Node<>(ele, null);
        this.head = new Node<>(null, tail);
        this.size = 1;
    }

    @Override
    public void enQueue(T ele) {
        if (isEmpty()) {
            this.tail = new Node<>(ele, null);
            this.head = new Node<>(null, tail);
        } else {
            Node<T> temp = new Node<>(ele, null);
            tail.setNext(temp);
            tail = temp;
        }

        size++;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> ret = head.getNext();
        head.setNext(ret.getNext());
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return ret.getData();
    }

    @Override
    public T getFront() {
        return isEmpty() ? null : head.getNext().getData();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
