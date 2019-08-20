package com.share.datastructure.api.impl;

public class BSTTreeMapNode<K,V> {
    private K key;
    private V value;
    private BSTTreeMapNode<K,V> left;
    private BSTTreeMapNode<K,V> right;

    public BSTTreeMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public BSTTreeMapNode(K key, V value, BSTTreeMapNode<K, V> left, BSTTreeMapNode<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BSTTreeMapNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BSTTreeMapNode<K, V> left) {
        this.left = left;
    }

    public BSTTreeMapNode<K, V> getRight() {
        return right;
    }

    public void setRight(BSTTreeMapNode<K, V> right) {
        this.right = right;
    }
}
