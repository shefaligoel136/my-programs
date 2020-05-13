package com.shefali.BinarySearchTree;

public class ShortestDiscBTWtwoNodes {
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
    public static int checkLargenSmall(Node root ,int a,int b){
        int temp;
        if(a>b){
            temp = b;
            b = a;
            a = b;
        }
        return distanceBTWnodes(root,a,b);
    }

    public static int distanceBTWnodes(Node root,int a,int b){
        if(root==null)
            return 0;
        if(root.data>a && root.data>b)
            return distanceBTWnodes(root.left,a,b);
        else if(root.data<a && root.data<b)
            return distanceBTWnodes(root.right,a,b);
        if(root.data>a && root.data<b)
            return distanceFromRoot(root,a)+distanceFromRoot(root,b);
        return 0;
    }
    public static int distanceFromRoot(Node root, int k){
        if(root.data==k)
            return 0;
        else if(root.data>k)
            return 1+ distanceFromRoot(root.left,k);
        return 1+ distanceFromRoot(root.right,k);
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = new Node(pre[0]);
        transform(root, pre, 1);
        int a = 1,b=40;
        System.out.println(checkLargenSmall(root,a,b));
    }

}
