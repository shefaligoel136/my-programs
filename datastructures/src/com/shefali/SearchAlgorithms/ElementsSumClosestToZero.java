package com.shefali.SearchAlgorithms;

import java.util.Arrays;

public class ElementsSumClosestToZero {
    public static void sumZero(int arr[]){
        Arrays.sort(arr);
        int sum = 0,i=0;
        int l = arr.length;
        int k = arr[i]+arr[l-1] ;
        while(i<l){
            sum = Math.abs(arr[i]+arr[l-1]);
            if(sum>0)
                i++;
            else
                l--;
            k = Math.min(sum,k);
        }
        System.out.println(k);
    }

    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -90, 85};
        sumZero(arr);
    }
}
