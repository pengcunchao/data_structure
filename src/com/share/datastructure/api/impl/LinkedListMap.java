package com.share.datastructure.api.impl;

import com.share.datastructure.api.Map;

public class LinkedListMap<K, V> implements Map<K, V> {
    private MapNode<K, V> dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new MapNode<>(null, null);
        this.size = size;
    }

    @Override
    public void add(K key, V value) {
        if (contains(key)) {
            getNode(key).setValue(value);
        } else {
            dummyHead.setNext(new MapNode<>(key, value, dummyHead.getNext()));
            size++;
        }
    }

    @Override
    public V remove(K key) {
        if (!contains(key)) {
            return null;
        }

        MapNode<K, V> cur = dummyHead;

        while (cur.getNext() != null) {
            if (key.equals(cur.getNext().getKey())) {
                break;
            }
            cur = cur.getNext();
        }

        if (cur.getNext() != null) {
            V ret = cur.getNext().getValue();
            cur.setNext(cur.getNext().getNext());
            size--;
            return ret;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key) == null ? null : getNode(key).getValue();
    }

    @Override
    public void set(K key, V value) {
        if (contains(key)) {
            getNode(key).setValue(value);
        }
        throw new IllegalOperationException(key + "doesn't exist!");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private MapNode<K, V> getNode(K key) {
        MapNode<K, V> cur = dummyHead.getNext();
        while (cur != null) {
            if (key.equals(cur.getKey())) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }
}
