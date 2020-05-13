package com.shefali.HeapDataStructure;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class IsBinaryTree_a_Heap {
    public static int count(Node root) {
        if (root == null)
            return 0;
        else
            return (1 + count(root.left) + count(root.right));
    }

    public static boolean isComplete(Node root, int index, int count) {
        if (root == null)
            return true;
        if (index >= count)
            return false;
        return isComplete(root.left, index * 2 + 1, count) &&
                isComplete(root.right, index * 2 + 2, count);
    }

    public static boolean isHeap(Node root) {
        if (root.left == null && root.right == null)
            return true;
        if (root.right == null)
            return root.data >= root.left.data;
        if (root.data >= root.left.data && root.data >= root.right.data)
            return isHeap(root.left) && isHeap(root.right);
        else
            return false;
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        int count = count(root);
        if (isComplete(root, 0, count) && isHeap(root))
            System.out.println("YES! It is");
        else
            System.out.println("No! It isn't");
    }
}
