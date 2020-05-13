package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TwoCousinsNoDuplicate {
    public static void twoCousin(Node root,int n1,int n2){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            int k = tmp.data;
            if (tmp != null) {
                if (tmp.left != null && tmp.left.data!=n1) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null && tmp.right.data!=n1) {
                    q.offer(tmp.right);
                }
            }
            else {
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }
    }
}
