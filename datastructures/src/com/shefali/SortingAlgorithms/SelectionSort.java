package com.shefali.SortingAlgorithms;

public class SelectionSort {
    public static void seletionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            int pos = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    pos = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[pos] = temp;
        }
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,7,2,4,6,8};
        seletionSort(arr);
    }
}
