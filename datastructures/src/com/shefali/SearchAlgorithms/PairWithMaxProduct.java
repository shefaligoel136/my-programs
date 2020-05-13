package com.shefali.SearchAlgorithms;

public class PairWithMaxProduct {
    public static void findPair(int arr[]){
        int max_pos1 = 0,max_pos2=0;
        int max_neg1 = 0,max_neg2=0;

        for(int i=0;i<arr.length;i++){
            if(max_pos1<arr[i]){
                max_pos2 = max_pos1;
                max_pos1 = arr[i];
            }
            else if(max_pos2<arr[i]){
                max_pos2 = arr[i];
            }
            if(arr[i]<0 && Math.abs(max_neg1)<Math.abs(arr[i])){
                max_neg2 = max_neg1;
                max_neg1 = arr[i];
            }
            else if(arr[i]<0 && Math.abs(max_pos2)<Math.abs(arr[i])){
                max_pos2 = arr[i];
            }
        }
        if(max_pos1*max_pos2>max_neg1*max_neg2)
            System.out.println(max_pos1+" "+max_pos2);
        else
            System.out.println(max_neg1+" "+max_neg2);
    }

    public static void main(String[] args) {
        int arr[] = {-1, -3, -4, 2, 0, -5,11};
        findPair(arr);
    }
}
