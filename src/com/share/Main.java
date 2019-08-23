package com.share;

import com.share.datastructure.api.Array;
import com.share.datastructure.api.Graph;
import com.share.datastructure.api.impl.DenseGraph;
import com.share.datastructure.api.impl.DynamicArray;
import com.share.datastructure.api.impl.SparseGraph;

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
 * Trie字典树
 * 并查集forest
 * 哈希表
 * 图
 * **/
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int capacity = 10;
        Array<Integer> nodes = new DynamicArray<>(capacity);
        for (int i = 0; i < capacity; i++) {
            nodes.add(i, i);
        }

        //Graph<Integer> graph = new DenseGraph<>(nodes);
        Graph<Integer> graph = new SparseGraph<>(nodes);
        graph.addEdge(0, 1, 100);
        graph.addEdge(8, 9, 100);

        System.out.println(graph.getWeight(0, 1));
        System.out.println(graph.getWeight(8, 9));
        System.out.println(graph.getWeight(8, 7));

        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);


    }
}
