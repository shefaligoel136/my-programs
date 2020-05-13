package com.shefali.SortingAlgorithms;

public class BubbleSort {
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,2,4,6,8};
        bubbleSort(arr);
    }
}
