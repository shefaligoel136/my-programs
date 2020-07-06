package com.shefali.HeapDataStructure;

public class HeapSort {
    public static void heapSort(int arr[]){
        int n = arr.length;
        for(int i = n/2-1 ; i>=0;i--)
            percolateDown(arr,n,i);
        for(int i = n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            percolateDown(arr,i,0);
        }
    }
    public static void percolateDown(int arr[], int n,int i) { // for max_heap
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n  && arr[l] > arr[max])
            max = l;
        else
            max = i;
        if (r < n && arr[r] > arr[max])
            max = r;
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            percolateDown(arr,n,max);
        }

    }

    public static void main(String[] args) {
        int arr[] = {3 ,5, 9, 6 ,8 ,20, 10, 12, 18 ,9};
        heapSort(arr);
        System.out.println();
        System.out.print("{");
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
    }
}
