package com.shefali.list;

public class StackNodeOperations implements NodeOperations {

    @Override
    public void push(Node head, int data) {

    }

    @Override
    public Node pop(Node head) {
        return null;
    }

    @Override
    public void show(Node head) {
        Node tmp = head;
        while(tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    @Override
    public int length(Node head) {
        return 0;
    }
}
