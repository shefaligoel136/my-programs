package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTdeletion {
    public static Node findNdel(Node root, int data){
        Node tmp = null ,check = null;
        boolean flag = false;
        if(root==null){
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            tmp = q.poll();
            if (tmp.data == data) {
                flag = true;
                check = tmp;
            }
            if (tmp.left != null) {
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                q.offer(tmp.right);
            }
        }
         if(flag==false){
             System.out.println("Not Found!");
             return root;
         }
         return delNode(root,tmp,check);
    }
    public static Node delNode(Node root,Node tmp,Node check) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node tmp1 = q.poll();
            if (tmp1.data == check.data){
                check.data = tmp.data;
            }
            if (tmp1.left != null) {
                if(tmp1.left.data == tmp.data){
                    tmp1.left = null;
                    break;
                }
                else {
                    q.offer(tmp1.left);
                }
            }
            if (tmp1.right != null) {
                if(tmp1.right.data == tmp.data){
                    tmp1.right = null;
                    break;
                }
                else {
                    q.offer(tmp1.right);
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

    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);


        int key = 11;
        Node ans = findNdel(root, key);
        System.out.print("\nInorder traversal after deletion:");
        inorder(ans);
    }
}
