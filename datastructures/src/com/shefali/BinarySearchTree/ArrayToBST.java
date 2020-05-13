package com.shefali.BinarySearchTree;

public class ArrayToBST {
    public static Node transform(int arr[],int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node newNode = new Node(arr[mid]);

        newNode.left = transform(arr,start,mid-1);
        newNode.right = transform(arr,mid+1,end);

        return newNode;
    }
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{11, 6, 13, 5, 12, 10};
        int n = arr.length;
        Node root = transform(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        preOrder(root);
    }
}
