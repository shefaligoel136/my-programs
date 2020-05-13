package com.shefali.list;

public class PriorityQueue implements NodeOperations {
    Node head = null;

    @Override
    public void push(int data) {
        Node tmp = head;
        if (tmp == null) // Insert 1st element
        {
            tmp = new Node(data, null);
            head = tmp;
        } else if (tmp.data < data) {
            tmp = new Node(data, null);
            tmp.next = head;
            head = tmp;
        } else {
            while (tmp.next != null && tmp.next.data > data) {
                tmp = tmp.next;
            }
            Node newNode = new Node(data, null);
            newNode.next = tmp.next;
            tmp.next = newNode;
        }

    }

    @Override
    public void del() {

    }

    @Override
    public void show() {
        Node tmp = head;
        if (tmp == null) {
            System.out.println("No element to show");
        } else {
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
    }

    @Override
    public void length() {

    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push(1);
        pq.push(5);
        pq.push(8);
        pq.push(11);
        pq.push(0);
        pq.push(3);
        pq.push(4);
        pq.push(9);

        pq.show();
    }
}
