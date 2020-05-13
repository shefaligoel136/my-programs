package com.shefali.BinarySearchTree;

public class NodeInGivenRange {
    public static int theRange(Node root, int low,int high){
        if(root==null)
            return 0;
        if(root.data>=low && root.data<=high)
            return 1+ theRange(root.left,low,high)+theRange(root.right,low,high);
        else if(root.data<low)
            return theRange(root.right,low,high);
        else
            return theRange(root.left,low,high);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.left.right = new Node(9);
        root.right.left = new Node(40);
        root.right.right = new Node(70);
        int low = 5, high = 40;
        System.out.println(theRange(root,low,high));
    }
}
