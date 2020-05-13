package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameLevel {
    static void sameLevel(Node root){
        boolean first = true,check=true;
        int curr = 1,temp=0,level = 0;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp!=null){
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
                if(tmp.left==null&&tmp.right==null){
                    if(first==true){
                        temp=level;
                        first = false;
                    }
                    else{
                        if(level!=temp){
                            check = false;
                            break;
                        }
                    }
                }
            }
            else{
                if(!q.isEmpty()) {
                    level = level + 1;
                    q.add(null);
                }
            }
        }
        if(check==true){
            System.out.println("Same level");
        }
        else{
            System.out.println("Not on same level");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        sameLevel(root);
    }
}
