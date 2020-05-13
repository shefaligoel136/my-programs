package com.shefali.SearchAlgorithms;

public class ElementInSortedRotatedArray {
    public static int findElement(int arr[],int low,int high,int key){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid]==key)
            return mid;
        if(arr[low]<=arr[mid]){
            if(key>=arr[low]&&key<=arr[mid])
                return findElement(arr,low,mid-1,key);
            return findElement(arr,mid+1,high,key);
        }
        if(key>=arr[mid]&&key<=arr[high])
            return findElement(arr,mid+1,high,key);
        return findElement(arr,low,mid-1,key);
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int ans = findElement(arr,0,arr.length-1,10);
        System.out.println(ans);
    }
}
