package com.shefali.BinarySearchTree;

public class GreaterSumTree {
    static int sum = 0;
    public static void transform(Node root){
        if(root==null)
            return;
        transform(root.right);
        sum = sum + root.data;
        System.out.println(sum);
        root.data = sum - root.data;
        transform(root.left);
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
        Node root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);
        transform(root);
        printInorder(root);
    }
}
