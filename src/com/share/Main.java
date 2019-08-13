package com.share;

import com.share.api.impl.TreeSegmentTree;

/**
 * 数组
 * 链表
 * 树
 * 栈
 * 队列
 * 堆
 * 集合
 * 映射
 * 线段树
 * **/
public class Main {

    public static void main(String[] args) {
        TreeSegmentTree<Integer> segmentTree = new TreeSegmentTree<>(new Integer[]{1, 5, 1, -9}, (a, b) -> a + b);
        System.out.println(segmentTree.query(0,3));
        System.out.println(segmentTree.query(1,3));
        segmentTree.update(0,10);
        System.out.println(segmentTree.query(0,3));
        System.out.println(segmentTree.query(0,2));

    }
}
