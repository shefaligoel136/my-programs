package com.shefali.BinarySearchTree;

public class BSTfromPreorder {
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

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = new Node(pre[0]);
        transform(root, pre, 1);
        System.out.println("Inorder traversal of the constructed tree is ");
        printInorder(root);

    }
}
