package com.share.datastructure.api.impl;

import com.share.datastructure.api.LinkedList;

public class SLinkedList<T> implements LinkedList<T> {
    private Node<T> dummyHead;
    private int size;

    public SLinkedList() {
        this.dummyHead = new Node<>(null, null);
        this.size = 0;
    }

    public SLinkedList(T ele) {
        this.dummyHead = new Node<>(null, new Node<>(ele, null));
        this.size = 1;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(int index, T ele) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of bound");
        }
        Node<T> temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setNext(new Node<>(ele, temp.getNext()));
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> temp = dummyHead.getNext();
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public void set(int index, T ele) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound");
        }
        Node<T> temp = dummyHead.getNext();
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setData(ele);
    }

    @Override
    public boolean contains(T ele) {
        Node<T> temp = dummyHead.getNext();
        while (temp != null) {
            if (ele.equals(temp.getData())) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of bound");
        }
        Node<T> temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        Node<T> ret = temp.getNext();
        temp.setNext(ret.getNext());
        ret.setNext(null);
        size--;
        return ret.getData();
    }

    @Override
    public boolean removeElement(T ele) {
        Node<T> cur = dummyHead;
        while(cur.getNext() != null){
            if(ele.equals(cur.getNext().getData())){
                break;
            }
            cur = cur.getNext();
        }

        if(cur.getNext() != null){
            cur.setNext(cur.getNext().getNext());
            size --;
            return true;
        }
        return false;
    }
}
