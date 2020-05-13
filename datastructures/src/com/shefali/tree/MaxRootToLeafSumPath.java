package com.shefali.tree;

public class MaxRootToLeafSumPath {
    static Node theFinalLeaf = null;
    static int maximum = 0;
    public static void maxRootToLeafSumPath(Node root){
        getLeaf(root,0,0);
        System.out.println("The maximum sum is "+" "+maximum);
        System.out.print("The path for the sum is: ");
        printPath(root,theFinalLeaf);
    }
    public static void getLeaf(Node root,int max,int sum){
        if(root==null)

            return;
        sum = sum+root.data;
        if(root.left==null&&root.right==null){
            if(sum>max){
                max = sum;
                theFinalLeaf = root;
                maximum = max;
            }
        }
        getLeaf(root.left,max,sum);
        getLeaf(root.right,max,sum);
    }
    public static boolean printPath(Node root,Node theFinalLeaf){
        if(root==null)
            return false;
        if(root==theFinalLeaf||printPath(root.left,theFinalLeaf)
                ||printPath(root.right,theFinalLeaf)){
        System.out.print(root.data+" ");
        return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        maxRootToLeafSumPath(root);
    }
}
