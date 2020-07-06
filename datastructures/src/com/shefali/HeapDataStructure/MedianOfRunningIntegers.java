package com.shefali.HeapDataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfRunningIntegers {
    public static void findMedian(int arr[]){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double median = arr[0];
        minHeap.add(arr[0]);
        System.out.println(median);
        for(int i = 1;i<arr.length;i++){
            if(maxHeap.size()>minHeap.size()){
                if(arr[i]<median){
                    int poll = maxHeap.poll();
                    minHeap.add(poll);
                    maxHeap.add(arr[i]);
                }
                else{
                    minHeap.add(arr[i]);
                }
                median = (double)(minHeap.peek()+maxHeap.peek())/2;

            }
            else if(maxHeap.size()<minHeap.size()){
                if(arr[i]>median){
                    int poll = minHeap.poll();
                    maxHeap.add(poll);
                    minHeap.add(arr[i]);
                }
                else{
                    maxHeap.add(arr[i]);
                }
                median = (double)(minHeap.peek()+maxHeap.peek())/2;
            }
            else{
                if(arr[i]<median) {
                    maxHeap.add(arr[i]);
                    median = (double)maxHeap.peek();
                }
                else{
                    minHeap.add(arr[i]);
                    median = (double)minHeap.peek();
                }

            }
            System.out.println(median);
        }

    }

    public static void main(String[] args) {
        int arr[] = {5, 15, 10, 20, 3};
        findMedian(arr);
    }
}
