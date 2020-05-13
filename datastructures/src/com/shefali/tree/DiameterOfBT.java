package com.shefali.tree;

public class DiameterOfBT {
    static int diameter=0;
    public static int diameterOfBT(Node root){
        int left,right;
        if(root==null)
            return 0;
        left = diameterOfBT(root.left);
        right = diameterOfBT(root.right);
        if(left+right+1>diameter) {
            diameter = left + right+1;
        }
        return Math.max(left,right)+1;
    }
    public static void main(String args[]) {
        Node root;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.right.right.left = new Node(80);
        root.right.right.left.right = new Node(90);
        diameterOfBT(root);
        System.out.println("The Diameter is "+diameter);
    }
}
