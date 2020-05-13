package com.shefali.BinarySearchTree;

public class InorderPredecessorAndSuccessor_Iterative {
    static class NewCheck {
        int data;
        NewCheck left, right;

        NewCheck() {
            left = null;
            right = null;
        }

        NewCheck(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static NewCheck pre;
    static NewCheck succ;

    public static void transform(NewCheck root, int arr[], int k) {
        if (root == null)
            return;
        for (int i = k; i < arr.length; i++) {
            int data = arr[i];
            add(root, data);
        }
    }

    public static void add(NewCheck root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new NewCheck(data);
            } else {
                add(root.right, data);
            }
        } else if (data < root.data) {
            if (root.left == null) {
                root.left = new NewCheck(data);
            } else {
                add(root.left, data);
            }
        }
    }

    public static void check(NewCheck root, int data) {
        if (root == null)
            return;
        while (root != null) {
            if (root.data == data) {
                if (root.left != null) {
                    NewCheck tmp = root.left;
                    while (tmp.right != null)
                        tmp = tmp.right;
                    pre = tmp;
                }
                if (root.right != null) {
                    NewCheck tmp = root.right;
                    while (tmp.left != null)
                        tmp = tmp.left;
                    succ = tmp;
                }
                return;
            } else if (root.data < data) {
                pre = root;
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = new int[]{50, 30, 20, 40, 70, 60, 80};
        NewCheck root = new NewCheck(arr[0]);
        transform(root, arr, 1);
        int key = 65;

        check(root, key);
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
