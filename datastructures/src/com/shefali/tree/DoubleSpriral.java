package com.shefali.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoubleSpriral {
    public static ArrayList<ArrayList<Integer>> doubleSpiral(Node root){
        int count = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return res;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        boolean leftToright = true;
        ArrayList<Integer> curr = new ArrayList<>();
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp!=null){
                curr.add(tmp.data);
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
            }
            else{
                if(leftToright){
                    ArrayList<Integer> c_curr = new ArrayList<>(curr);
                    res.add(c_curr);
                    curr.clear();
                    count++;
                }
                else{
                    Stack<Integer> s = new Stack<Integer>();
                    s.addAll(curr);
                    ArrayList<Integer> c_curr = new ArrayList<>();
                    while(!s.isEmpty()){
                        c_curr.add(s.pop());
                    }
                    res.add(c_curr);
                    curr.clear();
                    count++;
                }
                if(!q.isEmpty()){
                    q.offer(null);
                    if(count==2){
                        count = 0;
                        leftToright = !leftToright;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(1);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(2);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(2);
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.right.left.right.left = new Node(18);
        root.right.right.left.right = new Node(19);
        ArrayList<ArrayList<Integer>> al = doubleSpiral(root);
        for(Object i:al){
            System.out.println(i);
        }

    }
}
