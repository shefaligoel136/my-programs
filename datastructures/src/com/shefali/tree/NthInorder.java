package com.shefali.tree;

import java.sql.SQLOutput;

public class NthInorder {
    static int count = 0, flag;
    static void inorder(Node root,int key){
        if(root==null){
            return;
        }
        if(count<=key) {
            count++;
            inorder(root.left, key);

            if (count == key) {
                flag = root.data;
                //System.out.println("The node value is" + root.data);
            }
            //System.out.println("count"+ count);
            System.out.println(root.data + " ");
            inorder(root.right, key);
        }
    }
    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        int n = 4;

        inorder(root,n);
        System.out.println("The node value is "+ flag);
    }
}
