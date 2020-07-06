package com.shefali.list;

import java.util.Stack;

public class PrepBytes {
    public static Node binary(Node head) {
        Stack<Node> zero = new Stack<>();
        Stack<Node> one = new Stack<>();
        while (head != null) {
            if (head.data == 0)
                zero.push(head);
            else if (head.data == 1)
                one.push(head);
            head = head.next;
        }
        head = zero.pop();
        head.next = one.pop();
        Node tmp = head;
        head = head.next;
        while ((zero.size()>0&&one.size()>0)) {
            head.next = zero.pop();
            head.next.next = one.pop();
            if (zero.size()>0&&one.size()>0)
                head = head.next.next;
        }
        if (!zero.isEmpty() || !one.isEmpty())
            return null;
        else {
            head.next.next.next=null;
            return tmp;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Node n1 = new Node(1, null);
//        Node n2 = new Node(0, n1);
//        Node n3 = new Node(0, n2);
//        Node n4 = new Node(1, n3);
        Node n5 = new Node(1, null);
        Node n6 = new Node(0, n5);
        Node n7 = new Node(1, n6);
        Node n8 = new Node(0, n7);
        Node n9 = new Node(0, n8);
        Node n10 = new Node(1, n9);
        //n1.next = n10;
        Node tmp = binary(n10);
        if (tmp == null)
            System.out.println("-1");
        else {
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time is "+(end - start));
    }

//    static SinglyLinkedListNode BinaryList(SinglyLinkedListNode head)
//    {
//        int count_0 = 0;
//        int count_1 = 0;
//        SinglyLinkedListNode temp = head;
//        while(temp != null) {
//            if(temp.value == '0') {
//                count_0++;
//            } else {
//                count_1++;
//            }
//            temp = temp.next;
//        }
//        if(count_0 != count_1) {
//            return null;
//        }
//        SinglyLinkedListNode out, out1, out2;
//        out1 = new SinglyLinkedListNode('0');
//        out2 = new SinglyLinkedListNode('1');
//        out1.next = out2;
//        out = out1;
//        for(int i = 0 ; i < count_0 ; i++) {
//            out1 = new SinglyLinkedListNode('0');
//            out2.next = out1;
//            out2 = new SinglyLinkedListNode('1');
//            out1.next = out2;
//        }
//        return out;
//    }
}

