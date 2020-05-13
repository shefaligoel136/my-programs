package com.shefali.tree;
import java.util.*;

public class SymmetricTree {
    static void symmetricTree(Node root) {
        boolean flag = true;
        Queue<Node> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            Node tmpLeft = q.poll();
            Node tmpRight = q.poll();
            if(tmpLeft==null && tmpRight==null)
                continue;
            if((tmpLeft==null&&tmpRight!=null)||(tmpLeft!=null&&tmpRight==null)) {
                flag = false;
                break;
            }
            q.offer(tmpLeft.left);
            q.offer(tmpRight.right);
            q.offer(tmpLeft.right);
            q.offer(tmpRight.left);
        }

        if(flag==true){
            System.out.println("Symmetric");
        }
        else{
            System.out.println("Not Symmetric");
        }

        }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        symmetricTree(root);

    }
    }

