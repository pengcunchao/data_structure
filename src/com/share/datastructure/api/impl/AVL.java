package com.share.datastructure.api.impl;

import com.share.datastructure.api.Map;

public class AVL<K extends Comparable<K>, V> implements Map<K, V> {

    private Node<K, V> root;
    private int size;

    public AVL() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }

        if (key.compareTo(node.getKey()) == 0) {
            node.setValue(value);
            return node;
        } else if (key.compareTo(node.getKey()) < 0) {
            node.setLeftChild(add(node.getLeftChild(), key, value));
        } else {
            node.setRightChild(add(node.getRightChild(), key, value));
        }

        setHeight(node);


        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.getLeftChild()) >= 0) {
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.getRightChild()) <= 0) {
            return leftRotate(node);
        }
        if (balance > 1 && getBalance(node.getLeftChild()) < 0) {
            node.setLeftChild(leftRotate(node.getLeftChild()));
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.getRightChild()) > 0) {
            node.setRightChild(rightRotate(node.getRightChild()));
            return leftRotate(node);
        }

        return node;
    }

    private Node<K, V> rightRotate(Node<K, V> node) {
        Node<K, V> ret = node.getLeftChild();
        Node<K, V> t3 = ret.getRightChild();

        ret.setRightChild(node);
        node.setLeftChild(t3);

        setHeight(node);
        setHeight(ret);
        return ret;
    }

    private Node<K, V> leftRotate(Node<K, V> node) {
        Node<K, V> ret = node.getRightChild();
        Node<K, V> t3 = ret.getLeftChild();

        ret.setLeftChild(node);
        node.setRightChild(t3);

        setHeight(node);
        setHeight(ret);
        return ret;
    }

    private int getHeight(Node<K, V> node) {
        if (node == null) {
            return 0;
        }

        return node.getHeight();
    }

    private void setHeight(Node node) {
        node.setHeight(1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())));
    }

    private int getBalance(Node<K, V> node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
    }


    @Override
    public V remove(K key) {
        if (!contains(key)) {
            return null;
        }

        Node<K, V> ret = getNode(key);
        root = remove(root, key);
        return ret.getValue();
    }

    private Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        Node<K, V> ret = node;
        if (key.compareTo(node.getKey()) < 0) {
            node.setLeftChild(remove(node.getLeftChild(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRightChild(remove(node.getRightChild(), key));
        } else {
            if (node.getLeftChild() == null) {
                size--;
                ret = node.getRightChild();
            } else if (node.getRightChild() == null) {
                size--;
                ret = node.getLeftChild();
            } else {
                Node<K, V> min = min(node.getRightChild());
                Node<K, V> rightMin = remove(node.getRightChild(), min.getKey());

                ret = new Node<>(min.getKey(), min.getValue());
                ret.setLeftChild(node.getLeftChild());
                ret.setRightChild(rightMin);
            }
        }

        if (ret == null) {
            return null;
        }

        setHeight(ret);
        if (getBalance(ret) > 1 && getBalance(ret.getLeftChild()) >= 0) {
            return rightRotate(ret);
        } else if (getBalance(ret) > 1 && getBalance(ret.getLeftChild()) < 0) {
            ret.setLeftChild(leftRotate(ret.getLeftChild()));
            return rightRotate(ret);
        } else if (getBalance(ret) < -1 && getBalance(ret.getRightChild()) <= 0) {
            return leftRotate(ret);
        } else if (getBalance(ret) < -1 && getBalance(ret.getRightChild()) > 0) {
            ret.setRightChild(rightRotate(ret.getRightChild()));
            return leftRotate(ret);
        }

        return ret;
    }

    private Node<K, V> min(Node<K, V> node) {
        if (node == null) {
            return null;
        }

        Node<K, V> cur = node;
        while (cur.getLeftChild() != null) {
            cur = cur.getLeftChild();
        }
        return cur;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key) == null ? null : getNode(key).getValue();
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> cur = root;
        while (cur != null) {
            if (key.equals(cur.getKey())) {
                return cur;
            } else if (key.compareTo(cur.getKey()) < 0) {
                cur = cur.getLeftChild();
            } else {
                cur = cur.getRightChild();
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

    public class Node<K, V> {
        private K key;
        private V value;
        private int height;
        private Node<K, V> leftChild;
        private Node<K, V> rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
            this.leftChild = null;
            this.rightChild = null;
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

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node<K, V> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<K, V> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<K, V> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<K, V> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
