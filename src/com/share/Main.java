package com.share;

import com.share.api.impl.SimpleBSTree;

/**
 * 数组
 * 链表
 * 树
 * 栈
 * 队列
 * 堆
 * 集合
 * 映射
 * **/
public class Main {

    public static void main(String[] args) {
        SimpleBSTree<Integer> bsTree = new SimpleBSTree<>();
        bsTree.add(5);
        bsTree.add(3);
        bsTree.add(8);
        bsTree.add(2);
        bsTree.add(9);

        bsTree.traverse();
        System.out.println("--------------------");

        bsTree.remove(8);

        bsTree.traverse();
        System.out.println("--------------------");


        bsTree.remove(3);
        bsTree.traverse();
    }
}
