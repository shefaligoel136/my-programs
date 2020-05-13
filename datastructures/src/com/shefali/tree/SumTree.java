package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree {
    static int sumTree(Node root){
        int ls,rs;
        if(root == null || (root.left == null&&root.right == null ))
            return 1;
        ls = sum(root.left);
        rs = sum(root.right);
        if ((root.data == ls + rs) && (sumTree(root.left) != 0)
                && (sumTree(root.right)) != 0)
            return 1;

        return 0;
    }

    static int sum(Node node){
        if(node==null)
            return 0;
        return sum(node.left) + node.data + sum(node.right);
    }

    public static void main(String args[])
    {

        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        if (sumTree(root) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
