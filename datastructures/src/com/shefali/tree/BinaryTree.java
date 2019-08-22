package com.shefali.tree;
import java.math.*;

import static java.lang.Math.max;


public class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;
    BinaryTree root = null;
    static int size = 0;
    static int diameter;

    BinaryTree(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    void insert(int data, BinaryTree tmp)
    {
        if(data <= tmp.data) {
            if(tmp.left == null) {
                tmp.left = new BinaryTree(data);
                return;
            }
            insert(data, tmp.left);
        }
        else {
            if(tmp.right == null) {
                tmp.right = new BinaryTree(data);
                return;
            }
            insert(data, tmp.right);
        }
    }
/*BINARY TREE TRAVERAL*/
    void inOrderTraversal(BinaryTree tmp) {
        if(tmp == null) {
            return;
        }
        inOrderTraversal(tmp.left);
        System.out.print(tmp.data + " ");
        size = size+1;
        inOrderTraversal(tmp.right);
    }
    void size()
    {
        System.out.println("Size is " + size);
    }
/* MAXIMUN VALUE IN TREE*/
    public int maxInBinaryTree(BinaryTree root){
        int maxValue = Integer.MIN_VALUE;
        if(root != null)
        {
            int lm = maxInBinaryTree(root.left);
            int rm = maxInBinaryTree(root.right);

            if(lm>rm)
            {
                maxValue = lm;
            }
            else
            {
                maxValue = rm;
            }
            if(root.data>maxValue)
            {
                maxValue = root.data;
            }
        }
        return maxValue;

    }


/* Searching an element in tree*/
    public boolean search(BinaryTree root, int data)
    {   if(root == null)
            return false;
        if(root.data == data)
            return true;
        return search(root.left,data) || search(root.right,data);
    }

    public int calHeight(BinaryTree root)
    {
        int h1,h2,h,d;
        if(root == null)
            return 0;
        else {
            h1 = calHeight(root.left);
            h2 = calHeight(root.right);
            h = max(h1, h2) + 1;
            d = h1+h2+1;
            if(d>diameter)
                diameter = d;
            return h;
        }

    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.insert(10, root);
        root.insert(2, root);
        root.insert(51, root);
        root.insert(9, root);
        root.insert(4, root);
        root.insert(1, root);
        root.inOrderTraversal(root);
        System.out.println();
        System.out.println("Max element is "+ root.maxInBinaryTree(root));
        System.out.println(root.search(root,888));
        root.size();
        System.out.println("height is "+ root.calHeight(root));
        System.out.println("diameter is "+ diameter);
    }

}
