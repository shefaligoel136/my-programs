package com.shefali.SearchAlgorithms;

public class JumpSearch {
    public static int jumpSearch(int arr[],int x){
        int l = arr.length;
        int steps = (int)Math.floor(Math.sqrt(l));
        int k = steps;
        int prev = 0;

        while(arr[Math.min(steps,l)-1]<x){
            prev = steps;
            steps = steps+k;

            if(prev>=l)
                return -1;
        }
        while(arr[prev]<x){
            prev++;

            if(prev == Math.min(steps,l))
                return -1;
        }
        if (arr[prev] == x)
            return prev;

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int x = 55;

        int index = jumpSearch(arr, x);

        System.out.println("\nNumber " + x + " is at index " + index);
    }
}
