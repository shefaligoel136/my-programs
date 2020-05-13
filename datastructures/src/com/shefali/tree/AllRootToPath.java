package com.shefali.tree;

import java.util.ArrayList;

public class AllRootToPath {
    static ArrayList<Integer> al = new ArrayList<>();
    int l = 0;
    public static void allRootToPath(Node root) {
        if (root == null)
            return;
        al.add(root.data);
        if (root.left == null && root.right == null) {
            for (Integer e : al) {
                System.out.print(e + " ");
            }
            System.out.println();
        } else {
            allRootToPath(root.left);
            allRootToPath(root.right);
        }
        int l = al.size();
        al.remove(l - 1);
    }

    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.left.left = new Node(16);
        root.right.left.left.right = new Node(17);
        root.right.right = new Node(8);
        allRootToPath(root);
    }
}
