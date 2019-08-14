package com.share;

import com.share.api.impl.TreeSegmentTree;
import com.share.api.impl.Trie;

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
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("pig");

        System.out.println(trie.contains("apple"));
        System.out.println(trie.match("a..le"));
        System.out.println(trie.contains("peach"));
        System.out.println(trie.match("b.."));

    }
}
