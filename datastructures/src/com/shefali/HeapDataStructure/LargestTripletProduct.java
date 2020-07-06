package com.shefali.HeapDataStructure;

import java.util.PriorityQueue;

public class LargestTripletProduct {
    public static void product(int arr[], PriorityQueue<Integer> minHeap) {
        int prod = 1, no_1 , no_2, no_3;
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() != 3)
                System.out.println("-1");
            else {
                no_1 = minHeap.poll();
                no_2 = minHeap.poll();
                no_3 = minHeap.poll();
                prod = no_1 * no_2 * no_3;
                System.out.println(prod);
                prod = prod / no_1;
                minHeap.add(no_2);
                minHeap.add(no_3);
            }



        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        int arr[] = {1, 2, 3, 4, 5};
        product(arr, minHeap);
    }
}
