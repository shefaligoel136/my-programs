package com.shefali.hashing;

import com.shefali.tree.Node;

import java.util.Hashtable;
import java.util.Map;

public class VerticalSumInaGivenBinaryTree {
    static Hashtable<Integer, Integer> h = new Hashtable<>();

    public static void verticalSumofBT(TreeNode root, int n) {
        if (root == null)
            return;
        if (!h.containsKey(n)) {
            h.put(n, root.data);
        } else {
            h.put(n, h.get(n) + root.data);
        }
        verticalSumofBT(root.left, n - 1);
        verticalSumofBT(root.right, n + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        verticalSumofBT(root, 0);
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            System.out.println(e.getValue());
        }
    }

}

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
        left = null;
        right = null;
    }
}

