package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectBinaryTree {
    static void perfectBinaryTree(Node root) {
        boolean flag = true, flagforfull = true;
        int height = 1, firstNull = 0, save = 0, check;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp != null) {
                if (tmp.right != null && tmp.left != null) {
                    q.offer(tmp.left);
                    q.offer(tmp.right);
                } else if ((tmp.right == null && tmp.left != null) || (tmp.right != null && tmp.left == null)) {
                    flag = false;
                    flagforfull = false;
                    break;
                } else {
                    if (firstNull == 0) {
                        save = height;
                        firstNull = 1;
                    } else {
                        check = height;
                        if (save != check) {
                            flag = false;
                            break;
                        }
                    }
                }
            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                height = height + 1;
            }
        }
        if (flag == true) {
            System.out.println("Perfect Binary Tree");
        } else {
            System.out.println("Not a Perfect Binary Tree");
        }
        if (flagforfull == true) {
            System.out.println("Full Binary Tree");
        } else {
            System.out.println("Not a Full Binary Tree");
        }
    }

    public static void main(String args[]) {
        Node root;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        perfectBinaryTree(root);

    }
}
