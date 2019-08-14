package com.share;

import com.share.api.impl.RankUnionFind;

import java.util.Random;

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
 * **/
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 100000000;
        RankUnionFind rankUnionFind = new RankUnionFind(n);
        Random random = new Random();
        for (int i = 0; i < n -1; i++) {
            rankUnionFind.union(i, i+1);
        }
        System.out.println(rankUnionFind.isConnected(0, 1));
        System.out.println(rankUnionFind.isConnected(random.nextInt(n), random.nextInt(n)));
        System.out.println(rankUnionFind.isConnected(random.nextInt(n), random.nextInt(n)));
        System.out.println(rankUnionFind.isConnected(random.nextInt(n), random.nextInt(n)));
        System.out.println(rankUnionFind.isConnected(random.nextInt(n), random.nextInt(n)));
        System.out.println(rankUnionFind.isConnected(random.nextInt(n), random.nextInt(n)));

        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);


    }
}
