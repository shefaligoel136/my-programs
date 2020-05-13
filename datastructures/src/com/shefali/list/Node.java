package com.shefali.list;

public class Node {
    public int data;
    public Node next;

    Node(int data , Node next)
    {
        this.data = data;
        this.next = next;
    }

    public static Node createRandomData() {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        Node n4 = new Node(4, n3);
        Node n5 = new Node(5, n4);
        Node n6 = new Node(6, n5);
        Node n7 = new Node(7, n6);
        Node n8 = new Node(8, n7);
        Node n9 = new Node(9, n8);
        Node n10 = new Node(10, n9);
        n1.next = n10;
        return n1;
    }
}
