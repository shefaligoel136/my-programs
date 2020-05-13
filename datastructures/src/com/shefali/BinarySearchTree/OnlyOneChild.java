package com.shefali.BinarySearchTree;

public class OnlyOneChild {
    public static void find(int arr[]){
        int size = arr.length;
        int flag = 0;
        for(int i=0;i<size;i++){
            if(i+1<size&&i+2<size){
                if((arr[i+1]>arr[i]&&arr[i+2]>arr[i])||(arr[i+1]<arr[i]&&arr[i+2]<arr[i]))
                    continue;
                else
                    flag = 1;
            }
        }
        if(flag==0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        int pre[] = {8, 3, 5, 7, 6};
        find(pre);
    }
}
