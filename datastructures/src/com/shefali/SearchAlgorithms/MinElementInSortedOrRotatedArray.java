package com.shefali.SearchAlgorithms;

public class MinElementInSortedOrRotatedArray {
    public static int findNumber(int arr[], int low, int high){
        if(high<low)
            return arr[0];

        if(high==low)
            return arr[low];

        int mid = (low+high)/2;

        if(mid>low && arr[mid]<arr[mid-1])
            return arr[mid];

        if(mid<high && arr[mid+1]<arr[mid])
            return  arr[mid+1];

        if (arr[high] > arr[mid])
            return findNumber(arr, low, mid-1);
        return findNumber(arr, mid+1, high);
    }

    public static void main(String[] args) {
        int arr[] =  {5, 6, 7, 1, 2, 3, 4};
        int n = arr.length;
        System.out.println("The minimum element is "+ findNumber(arr, 0, n-1));
    }
}
