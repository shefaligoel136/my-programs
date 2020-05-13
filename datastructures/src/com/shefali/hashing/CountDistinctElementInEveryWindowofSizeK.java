package com.shefali.hashing;

import java.util.HashMap;
import java.util.Hashtable;

public class CountDistinctElementInEveryWindowofSizeK {
    public static void countDistinct(int arr[], int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (h.get(arr[i]) == null)
            {
                h.put(arr[i], 1);
                count++;
            } else {
                int cal = h.get(arr[i]);
                h.put(arr[i], cal+1);
            }
        }
        System.out.println(count);
        for (int i = k; i < arr.length; i++) {
            if (h.get(arr[i - k]) == 1) {
                h.remove(arr[i - k]);
                count--;
            } else {
                int cal = h.get(arr[i-k]);
                h.put(arr[i - k], cal - 1);
            }
            if (h.get(arr[i]) == null) {
                h.put(arr[i], 1);
                count++;
            } else {
                int cal = h.get(arr[i]);
                h.put(arr[i], cal + 1);
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinct(arr, k);
    }
}

