package com.share;

import com.share.api.Heap;
import com.share.api.impl.MinHeap;

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

        Heap<Integer> heap = MinHeap.heapify(new Integer[]{1, 9, 8, 2, 6, 4, 3, 5});

        for (int i = 0; i < 8; i++) {
            System.out.println(heap.pop());
        }

    }
}
