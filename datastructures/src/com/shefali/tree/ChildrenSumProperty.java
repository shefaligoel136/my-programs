package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperty {
    static void childrenSumProperty(Node root) {
        int sum = 0;
        boolean flag = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.left != null) {
                sum = sum + tmp.left.data;
                if(tmp.left.left!=null || tmp.left.right!=null)
                    q.offer(tmp.left);
            }
            if (tmp.right != null) {
                sum = sum + tmp.right.data;
                if(tmp.right.left!=null || tmp.right.right!=null)
                 q.offer(tmp.right);
            }
            //if(tmp.left != null && tmp.right != null ) {
                if (sum != tmp.data) {
                    flag = false;
                    break;
                }
            //}
            sum = 0;
        }
        if (flag == true) {
            System.out.println("The given tree satisfies the children sum property");
        } else
            System.out.println("The given tree does not satisfies the children sum property");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        childrenSumProperty(root);
    }
}
