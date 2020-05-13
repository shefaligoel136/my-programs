package com.shefali.BinarySearchTree;

public class MaxElementInPath {
    public static void transform(Node root, int arr[], int k) {
        if (root == null)
            return;
        for (int i = k; i < arr.length; i++) {
            int data = arr[i];
            add(root, data);
        }
    }

    public static void add(Node root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                add(root.right, data);
            }
        } else if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                add(root.left, data);
            }
        }
    }

    public static int theLCA(Node root, int a, int b) {
        while ((a < root.data && b < root.data) || (a > root.data && b > root.data)) {
            if (root.data > a && root.data > b)
                root = root.left;
            else if (root.data < a && root.data < b)
                root = root.right;
        }
        return Math.max(findmax(root, a), findmax(root, b));
    }

    public static int findmax(Node root, int k) {
        int max = -1;
        while (root.data != k) {
            if (root.data > k) {
                max = Math.max(max, root.data);
                root = root.left;
            } else {
                max = Math.max(max, root.data);
                root = root.right;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 47, 40, 50};
        Node root = new Node(pre[0]);
        transform(root, pre, 1);
        int a = 1, b = 40;
        System.out.println(theLCA(root, a, b));
    }

}

