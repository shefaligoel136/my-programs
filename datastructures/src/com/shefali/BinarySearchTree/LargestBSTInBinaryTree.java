package com.shefali.BinarySearchTree;

public class LargestBSTInBinaryTree {
    public static info findBST(Node root) {
        if (root == null)
            return new info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        if (root.left == null && root.right == null)
            return new info(1, root.data, root.data, 1, true);

        info l = findBST(root.left);
        info r = findBST(root.right);

        info ret = new info();
        ret.count_of_nodes = (1 + l.count_of_nodes + r.count_of_nodes);

        if (l.is_BST && r.is_BST && l.left_max < root.data &&
                r.right_min > root.data) {
            ret.right_min = Math.min(l.right_min, Math.min(r.right_min, root.data));
            ret.left_max = Math.max(r.left_max, Math.max(l.left_max, root.data));

            ret.ans = ret.count_of_nodes;
            ret.is_BST = true;

            return ret;
        }
        ret.ans = Math.max(l.ans, r.ans);
        ret.is_BST = false;

        return ret;
    }

    public static void main(String[] args) {
        Node  root = new Node(50);
        root.left    = new Node(30);
        root.right   = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.right = new Node(70);
        root.right.left = new Node(45);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        System.out.println(findBST(root).ans);
    }
}

class info {
    int count_of_nodes;
    int left_max;
    int right_min;
    int ans;
    boolean is_BST;

    info(int count_of_nodes, int left_max, int right_min, int ans, boolean is_BST) {
        this.count_of_nodes = count_of_nodes;
        this.left_max = left_max;
        this.right_min = right_min;
        this.ans = ans;
        this.is_BST = is_BST;
    }

    info() {
        int count_of_nodes = 0;
        int left_max = Integer.MIN_VALUE;
        int right_min = Integer.MAX_VALUE;
        int ans = 0;
        boolean is_BST = false;
    }
}