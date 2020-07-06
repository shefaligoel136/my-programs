package com.shefali.HeapDataStructure;

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static void insert(int arr[],PriorityQueue<Integer> minHeap){
        for(int i =0;i<arr.length;i++){
            minHeap.add(arr[i]);
        }
    }

    public static int connectRopes(PriorityQueue<Integer> minHeap) {
        int cost = 0;
        while(minHeap.size() >= 2) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            int c = min1 + min2;
            cost = cost + c;
            minHeap.add(c);
            System.out.println(minHeap);
        }
        return cost;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        int arr[] = { 4, 3, 6, 7, 2, 1, 5 };
        insert(arr, minHeap);
        System.out.println(minHeap);
        System.out.println(connectRopes(minHeap));
    }
}
