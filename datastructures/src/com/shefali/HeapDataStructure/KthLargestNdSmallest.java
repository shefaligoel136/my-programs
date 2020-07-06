package com.shefali.HeapDataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNdSmallest {
    public static void insert(int arr[],PriorityQueue<Integer> maxHeap,int k){
        for(int i =0;i<k;i++){
            maxHeap.add(arr[i]);
        }
    }
    public static void kthSmallest(int arr[],int k,PriorityQueue<Integer> maxHeap ){
        if(k<arr.length) {
            if (maxHeap.peek() > arr[k]) {
                maxHeap.poll();
                maxHeap.add(arr[k]);
                kthSmallest(arr,k+1,maxHeap);
            }
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int arr[] = { 12, 3, 5, 7, 19 };
        int k = 3;
        insert(arr,maxHeap,k);
        System.out.println(maxHeap);
        kthSmallest(arr,k,maxHeap);
        System.out.println(maxHeap.poll());

    }
}
