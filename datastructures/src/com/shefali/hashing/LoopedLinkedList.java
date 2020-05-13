package com.shefali.hashing;

import com.shefali.list.Node;

import java.util.Hashtable;
import java.util.LinkedList;

public class LoopedLinkedList {
    public static void loopedLinkedList(Node head) {
        boolean check = true;
        Hashtable<Node, Integer> h = new Hashtable<>();
        while (head != null) {
            if (!h.containsKey(head)) {
                h.put(head, head.data);
                head = head.next;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("It's a single Linklist");
        } else {
            System.out.println("It's a looped Linkedlist");
        }
    }

    public static void main(String[] args) {
        loopedLinkedList(Node.createRandomData());
    }

}
