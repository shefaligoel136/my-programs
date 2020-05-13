package com.shefali.tree;

public class DistanceLeftmostRightmost {

    public static int distance(Node root) {
        int left_val = leftProbe(root.left);
        System.out.print(root.data + " ");
        int right_val = rightProbe(root.right);
        return left_val + right_val + 1;
    }

    public static int leftProbe(Node root) {
        if (root == null)
            return 0;
        if (root.right != null && root.left == null) {
            int i = 1 + leftProbe(root.right);
            System.out.print(root.data + " ");
            return i;
        }
        int i = 1 + leftProbe(root.left);
        System.out.print(root.data + " ");
        return i;
    }

    public static int rightProbe(Node root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right == null) {
            System.out.print(root.data + " ");
            return 1 + rightProbe(root.left);
        }
        System.out.print(root.data + " ");
        return 1 + rightProbe(root.right);
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
        root.right.right.left = new Node(80);
        root.right.right.left.right = new Node(90);
        int ans = distance(root);
        System.out.println(ans);
    }
}
