package com.shefali.HeapDataStructure;


import java.util.PriorityQueue;

public class NodesLessThanX {
    public static void insert(int arr[], PriorityQueue minHeap){
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
        }
    }
    public static void findNumbers(int arr[],int x,int pos){
        if(pos>=arr.length)
            return;
        if(arr[pos]>=x)
            return;
        System.out.println(arr[pos]+" ");
        findNumbers(arr,x,2*pos+1);
        findNumbers(arr,x,2*pos+2);

    }

    public static void main(String[] args) {
        int arr[] = {2,3,15,5,4,45,80,6,150,77,120};
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        insert(arr,minHeap);
        int x = 80;
        for(int i = 0;i<arr.length;i++){
            arr[i] = minHeap.poll();
            System.out.println(arr[i]);
        }
        //findNumbers(arr,x,0);
    }
}
