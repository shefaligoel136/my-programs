package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorClass {
    static void mirrorClass(Node root1,Node root2) {
        boolean flag = true;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node tmp1 = q1.poll();
            Node tmp2 = q2.poll();
            if (tmp1 != null && tmp2 != null) {
                if (tmp1.data != tmp2.data) {
                    flag = false;
                    break;
                }
                q1.offer(tmp1.left);
                q1.offer(tmp1.right);
                q2.offer(tmp2.right);
                q2.offer(tmp2.left);
            }
            if (tmp1 == null && tmp2 == null) {
                flag = true;
                break;
            }
            if (tmp1 == null || tmp2 == null) {
                flag = false;
                break;
            }

        }
        if ((!q1.isEmpty() && q2.isEmpty()) || (q1.isEmpty() && !q2.isEmpty())) {
            flag = false;
        }

        if (flag == true) {
                System.out.println("Mirror Tree");
            } else {
                System.out.println("Not a Mirror Tree");
            }
        }
        public static boolean mirrorByRecursion(Node a,Node b) {
            if (a == null && b == null)
                return true;
            if (a == null || b == null)
                return false;
            if (a.data != b.data) {
                return false;
            }
            else{
                return(mirrorByRecursion(a.left,b.right)&&mirrorByRecursion(a.right,b.left));
            }
        }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        //mirrorClass(a,b);
        boolean ans = mirrorByRecursion(a,b);
        System.out.println(ans);
    }
}
