package com.shefali.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BTNode{
    int parent;
    int child;
}
public class TwoCousins {
    public static void twocousins(Node root,int n1,int n2){
        ArrayList<Node> al = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int i = 0;
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            int k = tmp.data;
            if (tmp != null) {
                if (tmp.data == n1 || tmp.data == n2) {

                }
                if (tmp.left != null) {
                    q.offer(tmp.left);
                    al.add(i,tmp);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }

            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }
    }

}
