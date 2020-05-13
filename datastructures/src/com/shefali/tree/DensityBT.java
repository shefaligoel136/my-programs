package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DensityBT {
    static void density(Node root){
        int height = 0, size = 0;
        float d;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp != null) {
                size = size + 1;
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            else {
                if(!q.isEmpty()) {
                    q.offer(null);
                }
                height = height + 1;
            }
        }
        //System.out.println(size + " " + height);
        d = (float)size/height;
        System.out.println("Density is "+ d);

    }

    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

       // double ans = density(root);
       // System.out.println("Density is " + ans);
        density(root);
    }
}
