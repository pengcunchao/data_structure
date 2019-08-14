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
        add(root, word, 0);
    }

    private void add(Node node, String word, int index) {
        if (index == word.length()) {
            return;
        }
        Character c = word.charAt(index);

        if (node.getNext().get(c) == null) {
            node.getNext().put(c, new Node(false, new HashMap<>()));
        }
        if (index == word.length() - 1 && !node.getNext().get(c).isWord()) {
            node.getNext().get(c).setWord(true);
            size++;
        }
        add(node.getNext().get(c), word, index + 1);
    }


    public boolean contains(String word) {
        return contains(root, word, 0);
    }

    private boolean contains(Node node, String word, int index) {
        Character c = word.charAt(index);

        if (!node.getNext().containsKey(c)) {
            return false;
        }

        if (index == word.length() - 1) {
            return node.getNext().get(c).isWord();
        }

        return contains(node.getNext().get(c), word, index + 1);
    }


    public boolean match(String pattern) {
        return match(root, pattern, 0);
    }

    private boolean match(Node node, String pattern, int index) {
        if (index == pattern.length()) {
            return true;
        }

        Character c = pattern.charAt(index);
        if (c.equals('.')) {
            for (Node child : node.getNext().values()) {
                if (match(child, pattern, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.getNext().get(c) == null) {
                return false;
            }
            return match(node.getNext().get(c), pattern, index + 1);
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
