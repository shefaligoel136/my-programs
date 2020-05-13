package com.shefali.tree;


import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LeftmostRightmost {
    public static void leftMostrightMost(Node root){
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        Node tmp;
        boolean left_check = false;
        int right_most=0;
        al.add(root.data);
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp!=null){
                if(tmp.left!=null){
                    q.offer(tmp.left);
                    if(left_check==false){
                        left_check = true;
                        al.add(tmp.left.data);
                    }
                    if(right_most != 0) {
                        right_most = 0;
                    }
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                    right_most = tmp.right.data;
                }
            }
            else{
                if(!q.isEmpty()) {
                    q.offer(null);
                    left_check = false;
                    if(right_most != 0) {
                        al.add(right_most);
                        right_most = 0;
                    }
                }
            }
        }
        for (Integer e : al) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.left.left = new Node(10);
        root.right.left.right = new Node(9);
        root.right.left.right.right = new Node(19);
        root.right.right = new Node(25);
        leftMostrightMost(root);
    }
}
