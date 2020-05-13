package com.shefali.hashing;

import java.sql.SQLOutput;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class LongestIncreasingConsecutiveSubsequence {
    public static void printingSequence(int arr[]) {
        int max = 0, key = 0;
        Hashtable<Integer, Integer> h = new Hashtable<>();
        for (int n : arr) {
            if (h.containsKey(n)) {
                continue;
            }
            if (!h.containsKey(n-1)) {
                h.put(n, 1);
            } else {
                h.put(n, h.get(n - 1) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            if (max < e.getValue()) {
                max = e.getValue();
                key = e.getKey();
            }
        }
        System.out.println(max);
        for (int i = 1; i <= max; i++) {
            System.out.println(key);
            --key;
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 12, 12, 10, 10, 11, 10};
        printingSequence(a);
    }
}
