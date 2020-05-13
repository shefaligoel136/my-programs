package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class KdistanceFromNode {
    public static void kDistanceFromNode(Node root, int k, int checkNode){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        Node tmp;
        boolean check = false;
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp!=null){
                if(tmp.data == checkNode){
                    check = true;
                }
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
            }
            else{
                if(!q.isEmpty()){
                    q.offer(null);
                    if(check == true){
                        k=k-1;
                    }
                    if(k==0){
                        for(Node i:q) {
                            if(i!=null)
                                System.out.println(i.data);
                        }
                        break;
                    }
                }
                }
            }
        }

    public static void main(String[] args) {
        Node root;
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.left.right.right.left = new Node(84);
        kDistanceFromNode(root,2,8);
    }
}
