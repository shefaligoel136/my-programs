package com.shefali.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    static Stack reverseLevelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            s.push(tmp.data);
            if(tmp!=null){
                if(tmp.right!=null)
                    q.offer(tmp.right);
                if(tmp.left!=null)
                    q.offer(tmp.left);
            }

        }
        return s;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Stack s = reverseLevelOrder(root);
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
}
