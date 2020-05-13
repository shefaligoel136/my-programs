package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class KdistanceFromRoot {
    public static void kDistanceFromRoot(Node root,int k){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        Node tmp;
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp!=null){
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
            }
            else{
                if(!q.isEmpty()){
                    q.offer(null);
                    k--;
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
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        kDistanceFromRoot(root,1);
    }
}
