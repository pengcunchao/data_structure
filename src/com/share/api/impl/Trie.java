package com.share.api.impl;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;
    private int size;

    public Trie() {
        this.root = new Node(false, new HashMap<>());
        this.size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(String word) {
        Node cur = root;
        Character c = null;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(!cur.next.containsKey(c)){
                cur.next.put(c, new Node(false, new HashMap<>()));
            }
            cur = cur.next.get(c);
        }

        if(!cur.isWord){
            cur.setWord(true);
            size ++;
        }

        add(root,word);
    }

    private void add(Node node, String word){
        Character c = word.charAt(0);
        if(!node.next.containsKey(c)){
            node.next.put(c,new Node(false, new HashMap<>()));
        }
        if(word.length() == 1){
            if(!node.next.get(c).isWord()) {
               node.getNext().get(c).setWord(true);
               size ++;
            }
        }
        else{
            add(node.next.get(c),word.substring(1));
        }

    }

    private class Node {
        private boolean isWord;
        private Map<Character, Node> next;

        public Node(boolean isWord, Map<Character, Node> next) {
            this.isWord = isWord;
            this.next = next;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public Map<Character, Node> getNext() {
            return next;
        }

        public void setNext(Map<Character, Node> next) {
            this.next = next;
        }
    }
}
