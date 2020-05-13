package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTinsertion {
    public static Node insertion(Node root,int data){
        if(root==null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp!=null){
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                else{
                    tmp.left = new Node(data);
                    return root;
                }

                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
                else{
                    tmp.right = new Node(data);
                    return root;
                }
            }
        }
        return root;
    }

    static void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String args[])
    {
        Node root;
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);


        int key = 12;
        Node ans = insertion(root, key);
        System.out.print("\nInorder traversal after insertion:");
        inorder(ans);
    }
}
