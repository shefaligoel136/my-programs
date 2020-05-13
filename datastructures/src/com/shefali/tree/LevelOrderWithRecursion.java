package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderWithRecursion {
    static Queue<Node> q = new LinkedList<>();
    public static void levelOrderWithRecursion(Node root){
        if(root==null)
            return;
        if(root.left!=null) {
            q.offer(root.left);
        }
        if(root.right!=null) {
            q.offer(root.right);
        }
        System.out.println(root.data);
        levelOrderWithRecursion(q.poll());
    }
    public static void main(String args[]) {
        Node root;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
       // root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        levelOrderWithRecursion(root);
    }
}
