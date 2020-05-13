package com.shefali.BinarySearchTree;

import java.util.HashSet;
import java.util.Hashtable;

public class PairWithGivenSum_Hashing {
    public static boolean findPair(Node root, int k, HashSet<Integer> h){
        if(root==null)
            return false;
        if(findPair(root.left,k,h))
            return true;
        if(h.contains(k-root.data)){
            System.out.println("The pair is "+root.data+" "+(k-root.data));
            return true;
        }
        else
            h.add(root.data);
        return findPair(root.right,k,h);

    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.left.right = new Node(9);
        root.right.left = new Node(40);
        root.right.right = new Node(70);
        HashSet<Integer> h = new HashSet<>();
        int k = 41;
        findPair(root,k,h);
    }
}
