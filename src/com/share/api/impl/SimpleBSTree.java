package com.share.api.impl;

import com.share.api.BSTree;
import com.share.api.Queue;

public class SimpleBSTree<T extends Comparable<T>> implements BSTree<T> {
    private BinaryTreeNode<T> root;
    private int size;

    public SimpleBSTree() {
        this.root = null;
        this.size = 0;
    }

    public SimpleBSTree(T val) {
        this.root = new BinaryTreeNode<>(val);
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
    public void add(T val) {
        root = add(root,val);
    }

    @Override
    public boolean contains(T val) {
        return contains(root, val);
    }

    @Override
    public void traverse() {
        traverse(root);
    }

    @Override
    public void remove(T val) {
        root = remove(root,val);
    }

    private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T val){
        if(node == null){
            return null;
        }

        if(val.equals(node.getValue())){
            if(node.getLeft() == null){
                size --;
                return node.getRight();
            }
            else if(node.getRight() == null){
                size --;
                return node.getLeft();
            }
            else{
                return new BinaryTreeNode<>(null,removeMax(node.getLeft()),node.getRight());
            }

        }
        else if(val.compareTo(node.getValue()) < 0){
            node.setLeft(remove(node.getLeft(),val));
        }
        else{
            node.setRight(remove(node.getRight(),val));
        }

        return node;
    }

    private BinaryTreeNode<T> removeMax(BinaryTreeNode<T> node) {
        return  null;
    }



    private void traverse(BinaryTreeNode<T> node){
        if(node == null){
            return;
        }
        node.handle();
        traverse(node.getLeft());
        traverse(node.getRight());
    }

    public void LayerTraverse(){
        Queue<BinaryTreeNode<T>> queue = new LoopQueue<>();
        queue.enQueue(root);
        BinaryTreeNode<T> cur = null;
        while(!queue.isEmpty()){
            cur = queue.deQueue();
            cur.handle();
            if(cur.getLeft() != null)
                queue.enQueue(cur.getLeft());
            if(cur.getRight() != null)
                queue.enQueue(cur.getRight());
        }
    }

    private boolean contains(BinaryTreeNode<T> node, T val){
        if(node == null){
            return false;
        }

        if(val.equals(node.getValue())){
            return true;
        }
        else if(val.compareTo(node.getValue()) < 0){
            return contains(node.getLeft(),val);
        }
        else{
            return contains(node.getRight(),val);
        }
    }

    private BinaryTreeNode<T> add(BinaryTreeNode<T> node, T val){
        if(node == null){
            size ++;
            return new BinaryTreeNode<>(val);
        }

        if(val.compareTo(node.getValue()) < 0){
            node.setLeft(add(node.getLeft(),val));
        }
        else if(val.compareTo(node.getValue()) > 0){
            node.setRight(add(node.getRight(),val));
        }

        return node;
    }
}
