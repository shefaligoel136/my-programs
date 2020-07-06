package com.shefali.HeapDataStructure;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void sortIt(int arr[], int k,PriorityQueue<Integer> minHeap){
        for(int i =0;i<k+1;i++){
            minHeap.add(arr[i]);
        }
        int index= 0 ;
        for(int x=k+1;x<arr.length;x++){
            arr[index++] = minHeap.poll();
            minHeap.add(arr[x]);
        }
        Iterator<Integer> itr = minHeap.iterator();

        while(itr.hasNext())
        {
            arr[index++] = minHeap.poll();
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int arr[] =  {6,5,3,2,8,10,9};
        int k = 3;
        sortIt(arr,k+1,minHeap);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
