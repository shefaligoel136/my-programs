package com.shefali.tree;

import java.util.*;

public class PerfectLevelSet1 {
    static void perfectLevelS1(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        double count = 0,count1 = 1;
        double flag = 1,flag1=0 ;
        System.out.print(root.data+ " ");
        System.out.print(root.left.data+ " ");
        System.out.print(root.right.data+ " ");
        q1.offer(root.left);
        q1.offer(null);
        q2.offer(root.right);
        //q2.offer(null);
        while (!q1.isEmpty()) {
            Node tmp = q1.poll();
            if (tmp != null) {
                if (tmp.left != null) {
                    q1.offer(tmp.left);
                    q.offer(tmp.left.data);
                }
                if (tmp.right != null) {
                    q1.offer(tmp.right);
                    q.offer(tmp.right.data);
                }
                count++;
            } else {
                while(count1 <= Math.pow(2,flag1)) {
                    Node temp = q2.poll();
                    if (temp != null) {
                        if (temp.left != null) {
                            q2.offer(temp.left);
                            s.push(temp.left.data);
                        }
                        if (temp.right != null) {
                            q2.offer(temp.right);
                            s.push(temp.right.data);
                        }
                    }
                    count++;
                    count1++;
                }
            }
            if (count == Math.pow(2,flag)) {
                while (!q.isEmpty() && !s.isEmpty()) {
                    System.out.print(q.poll()+ " ");
                    System.out.print(s.pop()+ " ");
                }
                 count = 0;
                 count1 = 1;
                 flag = flag+1;
                flag1 = flag1+1;
                q1.offer(null);
                //q2.offer(null);
            }

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        root.left.left.left.left = new Node(16);
        root.left.left.left.right = new Node(17);
        root.left.left.right.left = new Node(18);
        root.left.left.right.right = new Node(19);
        root.left.right.left.left = new Node(20);
        root.left.right.left.right = new Node(21);
        root.left.right.right.left = new Node(22);
        root.left.right.right.right = new Node(23);
        root.right.left.left.left = new Node(24);
        root.right.left.left.right = new Node(25);
        root.right.left.right.left = new Node(26);
        root.right.left.right.right = new Node(27);
        root.right.right.left.left = new Node(28);
        root.right.right.left.right = new Node(29);
        root.right.right.right.left = new Node(30);
        root.right.right.right.right = new Node(31);
        perfectLevelS1(root);
    }
}
