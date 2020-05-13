package com.shefali.tree;

public class SumPath {
    public static boolean sumPath(Node root, int sum){
        if(root == null){
            return false;
        }
        System.out.println(root.data + " " + sum);
        if(root.left==null && root.right==null && root.data==sum){
            System.out.println(sum);
            return true;
        }
        else{
            return sumPath(root.left,sum-root.data) || sumPath(root.right,sum-root.data);
        }
    }

    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(27);
        root.right = new Node(9);
        root.right.left = new Node(5);
        root.right.left.left = new Node(6);
        root.right.left.left.right = new Node(7);
        root.right.right = new Node(8);
        boolean ans = sumPath(root,37);
        if(ans==true){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
