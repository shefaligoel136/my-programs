package com.shefali.hashing;

import java.util.Hashtable;
import java.util.Map;

public class PairsWhoseSumIsDivisibleByK {
    public static void findPair(int arr[], int k) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        if (sum % k != 0) {
            return;
        }

        Hashtable<Integer, Integer> h = new Hashtable<>();
        for (Integer a : arr) {
            if (!h.containsValue(a % k)) {
                h.put(a%k, 1);
            } else {
                Integer count = h.get(a % k);
                System.out.println("count" + count);
                h.put(a%k, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            int no = e.getKey();
            int toFind = k - no;
            if (h.containsKey(toFind)) {
                int freq = h.get(toFind);
                if (e.getValue()== freq) {
                    System.out.println("{" + e.getKey() + "," + toFind + "}");
                }
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int k = 10;
        if (arr.length % 2 == 0)
            findPair(arr, k);
    }
}
