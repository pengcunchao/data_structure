package com.share.api.impl;

import com.share.api.Map;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private BSTTreeMapNode<K, V> root;
    private int size;

    public TreeMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private BSTTreeMapNode<K, V> add(BSTTreeMapNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new BSTTreeMapNode<>(key, value);
        }

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(add(node.getLeft(), key, value));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(add(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }

        return node;
    }

    @Override
    public V remove(K key) {
        if (!contains(key)) {
            return null;
        }

        BSTTreeMapNode<K, V> ret = getNode(key);
        root = remove(root, key);
        return ret.getValue();
    }

    private BSTTreeMapNode<K, V> remove(BSTTreeMapNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(remove(node.getLeft(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(remove(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                size--;
                return node.getRight();
            } else if (node.getRight() == null) {
                size--;
                return node.getLeft();
            } else {
                return new BSTTreeMapNode<>(min(node.getRight()).getKey(), min(node.getRight()).getValue(), node.getLeft(), removeMin(node.getRight()));
            }
        }

        return node;
    }

    private BSTTreeMapNode<K, V> min(BSTTreeMapNode<K, V> node) {
        if (node == null) {
            return null;
        }

        BSTTreeMapNode<K, V> cur = node;
        while (cur.getLeft() != null) {
            cur = cur.getLeft();
        }
        return cur;
    }

    private BSTTreeMapNode<K, V> removeMin(BSTTreeMapNode<K, V> node) {
        if (node == null) {
            return node;
        }

        if (node.getLeft() != null) {
            node.setLeft(removeMin(node.getLeft()));
        } else {
            size--;
            node = node.getRight();
        }

        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key) == null ? null : getNode(key).getValue();
    }

    private BSTTreeMapNode<K, V> getNode(K key) {
        BSTTreeMapNode<K, V> cur = root;
        while (cur != null) {
            if (key.equals(cur.getKey())) {
                return cur;
            } else if (key.compareTo(cur.getKey()) < 0) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }

        return null;
    }

    @Override
    public void set(K key, V value) {
        if (contains(key)) {
            getNode(key).setValue(value);
            return;
        }

        throw new IllegalOperationException(key + "doesn't exist!");
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
