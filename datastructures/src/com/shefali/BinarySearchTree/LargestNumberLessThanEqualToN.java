package com.shefali.BinarySearchTree;

public class LargestNumberLessThanEqualToN {
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
    public static int findMaxforN(Node root, int n){
        if (root == null)
            return -1;

        if(n == root.data)
            return n;

        if(root.data<n){
            int k = findMaxforN(root.right,n);
            if(k==-1)
                return root.data;
            else
                return k;
        }
        else if(root.data>n)
            return findMaxforN(root.left,n);
        return -1;
    }


    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = new Node(pre[0]);
        transform(root, pre, 1);
        int n = 4;
        System.out.println(findMaxforN(root,n));
    }
}
