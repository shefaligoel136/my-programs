package com.shefali.BinarySearchTree;

public class ClosestElementInBST {
    static int min = Integer.MAX_VALUE;
    public static void findNumber(Node root,int k){
        if(root==null)
            return ;
        if(root.data>k){
            min = Math.min(min,Math.abs(root.data-k));
            findNumber(root.left,k);
        }
        else if(root.data<k){
            min = Math.min(min,Math.abs(root.data-k));
            findNumber(root.right,k);
        }
    }
    public static void main(String[] args) {
        Node  root = new Node(9);
        root.left    = new Node(4);
        root.right   = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(22);
        root.right.right.left = new Node(20);
        int k = 18;
        findNumber(root,k);
        System.out.println(min);
    }
}
