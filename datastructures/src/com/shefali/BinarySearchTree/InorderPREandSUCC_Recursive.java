package com.shefali.BinarySearchTree;

public class InorderPREandSUCC_Recursive {
    static Node pre;
    static Node succ;

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

    public static void check(Node root,int data) {
        if (root == null)
            return;
        if (root.data == data)
        {
            if (root.left != null)
            {
                pre = root.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
            }
            if(root.right != null){
                succ = root.right;
                while(succ.left != null) {
                    succ = succ.left;
                }
            }
            return;
        }
        else if (root.data > data)
        {
            succ = root;
            check(root.left,data);
        }
        else
        {
            pre = root;
            check(root.right,data);
        }
    }


    public static void main(String[] args) {
        int arr[] = new int[]{50, 30, 20, 40, 70, 60, 80};
        Node root = new Node(arr[0]);
        transform(root, arr, 1);
        int data = 65;

        check(root,data);
        if (pre != null)
            System.out.println("Predecessor is " +
                    pre.data);
        else
            System.out.print("-1");

        if (succ != null)
            System.out.print("Successor is " + succ.data);
        else
            System.out.print("-1");
    }

}
