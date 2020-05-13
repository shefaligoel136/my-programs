package com.shefali.tree;

import java.util.ArrayList;

public class PathOfGivenNode {
    static ArrayList<Integer> al = new ArrayList<>();

    public static void pathOfGivenNode(Node root, int node) {
        if (root == null)
            return;
        al.add(root.data);
       // System.out.println(root.data);
        if ((root.left == null && root.right == null && root.data == node)||(root.data==node)) {
            for (Integer e : al) {
                System.out.print(e + " ");
            }
            System.out.println();
        } else {
            pathOfGivenNode(root.left, node);
            pathOfGivenNode(root.right, node);
        }
        int l = al.size();
        al.remove(l - 1);
    }

    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(27);
        root.right = new Node(9);
        root.right.left = new Node(5);
        root.right.left.left = new Node(6);
        root.right.left.left.right = new Node(7);
        root.right.right = new Node(8);
        pathOfGivenNode(root, 5);
        pathOfGivenNode(root, 47);

    }
}
