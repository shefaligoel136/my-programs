package com.shefali.tree;

public class CheckSequence {
    static boolean checkSequence(Node root,int arr[]) {
        int l = arr.length;
        int i = 0;
        //boolean check = true;
        if (root.data == arr[i]) {
            i++;
            while (root != null && i < l) {
                if((root.left==null && root.right==null) && (root.data==arr[i]
                        && root.data==arr[arr.length-1])){
                    return true;
                }
                else if (root.left!=null && root.left.data == arr[i]) {
                    root = root.left;
                    i++;
                }
                else if(root.right!=null && root.right.data == arr[i]){
                    root = root.right;
                    i++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {5, 8, 6, 7};
        Node root=new Node(5);
        root.left=new Node(3);
        root.right=new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);

        if(checkSequence(root, arr))
        {
            System.out.print("Path Exists");
        }
        else
        {
            System.out.print("Path does not Exist");
        }
    }
}
