package com.shefali.HeapDataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dearrangement {

    public static void theDearrangement(int arr[], PriorityQueue<Integer> heap){
        for(int i=0;i<arr.length;i++){
            heap.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            int peek = heap.peek();
            heap.poll();
            if(peek != arr[i]){
                arr[i] = peek;
            }
            else{
                arr[i] = heap.peek();
                heap.poll();
                heap.add(peek);
                }
            }
        if(arr.length%2!=0){
            int temp = arr[arr.length-1];
            arr[arr.length-1] = arr[arr.length-2];
            arr[arr.length-2] = temp;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int arr1[] = {1,2,3,4,5,6};
        theDearrangement(arr1, minHeap);
        for(int i = 0;i<arr1.length;i++)
            System.out.print(arr1[i]+" ");

        System.out.println();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int arr2[] = {56, 21, 42, 67, 23};
        theDearrangement(arr2, maxHeap);
        for(int i = 0;i<arr2.length;i++)
            System.out.print(arr2[i]+" ");
    }
}
