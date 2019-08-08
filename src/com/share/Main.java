package com.share;

import com.share.api.Array;
import com.share.api.impl.DynamicArray;
import com.share.api.impl.Node;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new DynamicArray<>();
        for (int i =0;i<10;i++){
            array.add(i,i);
        }
        System.out.println(array.get(6));
        System.out.println("-----------------------------");

        Node<Integer> ret = removeElement(buildLinkedList(),2);
        while(ret != null){
            System.out.println(ret.getData());
            ret = ret.getNext();
        }
    }

    public static <T> Node<T> removeElement(Node<T> head, T val) {
        Node<T> dummyHead = new Node<>(null, head);
        Node<T> prev = dummyHead;
        while (prev.getNext() != null) {
            if (val.equals(prev.getNext().getData())) {
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return dummyHead.getNext();
    }

    private static Node<Integer> buildLinkedList() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> cur = head;
        for (int i = 0; i < 10; i++) {
            cur.setNext(new Node<>(i % 4));
            cur = cur.getNext();
        }
        return head;
    }
}
