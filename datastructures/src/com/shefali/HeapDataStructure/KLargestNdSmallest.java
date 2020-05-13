package com.shefali.HeapDataStructure;

import java.util.PriorityQueue;

public class KLargestNdSmallest {
    public static void insert(int arr[],PriorityQueue<Integer> minHeap,int k){
        for(int i =0;i<=k;i++){
            minHeap.add(arr[i]);
        }
    }

    public static void kLargest(int arr[],PriorityQueue<Integer> minHeap,int k){
        minHeap.poll();
        if(k+1!=arr.length) {
            minHeap.add(arr[k + 1]);
            kLargest(arr, minHeap, k + 1);
        }
        else return;

    }
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int arr[] = {11, 3, 2, 1, 15, 5, 4,45, 88, 96, 50, 45};
        int k = 3;
        insert(arr,minHeap,k);
        kLargest(arr,minHeap,k);
        System.out.println(minHeap);
    }
}
