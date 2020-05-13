package com.shefali.SearchAlgorithms;
import java.util.Arrays;

public class PairWithGivenDifference {
    public static void pair(int arr[],int n){
        Arrays.sort(arr);
        int i = 0, j=1;
        while (i<arr.length&&j<arr.length){
            if(i!=j && arr[j]-arr[i]==n){
                System.out.print("Pair Found: "+
                        "( "+arr[i]+", "+ arr[j]+" )");
                return;
            }
            else if(arr[j]-arr[i]<n)
                j++;
            else
                i++;
        }
        System.out.println("No such pair found");
    }
    public static void main (String[] args)
    {
        int arr[] = {1, 8, 30, 40, 100};
        int n = 0;
        pair(arr,n);
    }
}
