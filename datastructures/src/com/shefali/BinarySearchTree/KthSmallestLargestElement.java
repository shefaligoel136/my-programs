package com.shefali.BinarySearchTree;

public class KthSmallestLargestElement {
    public static RankNode insert(RankNode root, int x) {
        if (root == null)
            return new RankNode(x);

        if (x < root.data) {
            //System.out.println("for insertion");
            root.left = insert(root.left, x);
            root.lCount++;
            //System.out.println("root node is "+ root.data+" The count is "+root.lCount+" Inserted "+x);
        } else if (x > root.data) {
            //System.out.println("in right for");
            root.right = insert(root.right, x);
            root.rcount++;
        }
        //System.out.println("for main root return "+ root.data);
        return root;
    }

    public static RankNode kthSmallest(RankNode root, int k) {
        if (root == null)
            return null;

        int count = root.lCount + 1;
        //System.out.println(count);
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - count);
    }
    public static RankNode kthLargest(RankNode root, int k) {
        if (root == null)
            return null;

        int count = root.rcount + 1;
        //System.out.println(count);
        if (count == k)
            return root;

        if (count > k)
            return kthLargest(root.right, k);

        return kthLargest(root.left, k - count);
    }

    public static void main(String args[]) {
        RankNode root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};

        for (int x : keys)
            root = insert(root, x);

        int k = 4;
        RankNode res1 = kthSmallest(root, k);
        if (res1 == null)
            System.out.println("There are less "
                    + "than k nodes in the BST");
        else
            System.out.println("K-th Smallest"
                    + " Element is " + res1.data);
        RankNode res2 = kthLargest(root, 2);

        if (res2 == null)
            System.out.println("There are large "
                    + "than k nodes in the BST");
        else
            System.out.println("K-th largest"
                    + " Element is " + res2.data);
    }
}

