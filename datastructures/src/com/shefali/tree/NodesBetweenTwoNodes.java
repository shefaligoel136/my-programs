package com.shefali.tree;

public class NodesBetweenTwoNodes {

    public static int nodesBetweenTwoNodes(Node root, int n1,int n2) {
        Node lca = theLCA(root, n1, n2);

        int d1 = findEachHeight(lca,n1,0);
        int d2 = findEachHeight(lca,n2,0);

        return d1+d2;
    }


    public static Node theLCA(Node root,int n1,int n2) {
        if (root == null)
            return root;
        if (root.data == n1 || root.data == n2)
            return root;
        Node left = theLCA(root.left, n1, n2);
        Node right = theLCA(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        else
            return (left != null ? left : right);
    }

    public static int findEachHeight(Node root,int num, int height){
        if(root==null)
            return -1;
        if(root.data==num)
            return height;
        int left = findEachHeight(root.left,num,height+1);
        if(left==-1)
            return findEachHeight(root.right,num,height+1);
        return left;

}


    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        int count = nodesBetweenTwoNodes(root, 50, 60);
        System.out.println(count);
    }
}
