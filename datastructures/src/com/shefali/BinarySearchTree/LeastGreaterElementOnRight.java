package com.shefali.BinarySearchTree;

public class LeastGreaterElementOnRight {
    public static void transform(int arr[]) {
        Node root = new Node(arr[arr.length - 1]);
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            Node succ = null;
            succ = add(root, arr[i], succ);
            if (succ == null)
                arr[i] = -1;
            else
                arr[i] = succ.data;
        }
    }

    public static Node add(Node root, int data, Node succ) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new Node(data);
                return succ;
            } else {
                return add(root.right, data, succ);
            }
        } else if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
                return root;
            } else {
                return add(root.left, data, root);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int arr[] = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        transform(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
