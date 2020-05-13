package com.shefali.SearchAlgorithms;

public class ExponentialSearch {
    public static int exponentialSearch(int arr[],int n ,int x){
        if(arr[0]==x){
            return 0;
        }
        int i = 1;
        while(i<n && arr[i]<=x){
            System.out.println("i ="+ i+"<"+n+" "+arr[i]+"<="+x);
            i = i*2;
            System.out.println(i);
        }
        return binarySearch(arr,i/2,Math.min(i, n), x);
    }
    public static int binarySearch(int arr[],int l,int r,int x){
        if(r>=l){
            int mid = l + (r - l)/2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);

            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }
    public static void main(String args[])
    {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        int result = exponentialSearch(arr, arr.length, x);

        System.out.println((result < 0) ? "Element is not present in array" :
                "Element is present at index " +
                        result);
    }
}
