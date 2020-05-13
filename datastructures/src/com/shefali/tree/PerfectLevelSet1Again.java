package com.shefali.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectLevelSet1Again {
    public static void perfectLevelSet1Again(Node root){
        LinkedList<Node> q=new LinkedList<>();// current process
        LinkedList<Node> q1=new LinkedList<>();// jo naye list bnegi jisko process krna hai
        q.offer(root);
        System.out.print(root.data + " ");
        Node tmp;
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp!=null){
                if(tmp.left!=null)
                    q1.offer(tmp.left);
                if(tmp.right!=null)
                    q1.offer(tmp.right);
            }
            if(q.isEmpty() && !q1.isEmpty()) {
                Iterator<Node> ascendingIterator = q1.iterator();
                Iterator<Node> descendingIterator = q1.descendingIterator();
                Node ascendingNext = ascendingIterator.next();
                Node descendingNext = descendingIterator.next();
                do {
                    System.out.print(ascendingNext.data + " " + descendingNext.data + " ");
                    ascendingNext = ascendingIterator.next();
                    descendingNext = descendingIterator.next();
                } while(ascendingNext.data < descendingNext.data);
                q = q1;
                q1 = new LinkedList<>();
            }
        }
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
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        root.left.left.left.left = new Node(16);
        root.left.left.left.right = new Node(17);
        root.left.left.right.left = new Node(18);
        root.left.left.right.right = new Node(19);
        root.left.right.left.left = new Node(20);
        root.left.right.left.right = new Node(21);
        root.left.right.right.left = new Node(22);
        root.left.right.right.right = new Node(23);
        root.right.left.left.left = new Node(24);
        root.right.left.left.right = new Node(25);
        root.right.left.right.left = new Node(26);
        root.right.left.right.right = new Node(27);
        root.right.right.left.left = new Node(28);
        root.right.right.left.right = new Node(29);
        root.right.right.right.left = new Node(30);
        root.right.right.right.right = new Node(31);
        perfectLevelSet1Again(root);
    }
}
