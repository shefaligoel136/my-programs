package com.shefali.BinarySearchTree;

public class RemoveKeysOutOfRange {
    public static Node removeOutsideRange(Node root, int min, int max)
    {
        if(root == null)
        {
            return null;
        }
        root.left = removeOutsideRange(root.left,
                min, max);
        root.right = removeOutsideRange(root.right,
                min, max);
        if(root.data < min)
        {
            Node rchild = root.right;
            root = null;
            return rchild;
        }
        if(root.data > max)
        {
            Node lchild = root.left;
            root = null;
            return lchild;
        }
        return root;
    }
    public static void inorderTraversal(Node root)
    {
        if(root != null)
        {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(-13);
        root.right = new Node(14);
        root.left.right = new Node(-8);
        root.right.left = new Node(13);
        root.right.left.left = new Node(7);
        root.right.right = new Node(15);
        root = removeOutsideRange(root, -10, 13);
        inorderTraversal(root);
    }
}
