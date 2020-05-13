package com.shefali.hashing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SameSetOfNumbers {
    public static void sameSet(int[] a, int[] b) {
        boolean ans = true;
        int max = 0, max_no = 0;
        if (a.length == b.length) {
            Hashtable<Integer, Integer> h = new Hashtable<>();
            for (int i : a) {
                Integer counter = h.get(i);
                if (counter == null) {
                    counter = 1;
                } else {
                    counter = counter + 1;
                }
                h.put(i, counter);
            }
            for (int i : b) {
                Integer counter = h.get(i);
                if (counter == null) {
                    counter = -1;
                } else {
                    counter = counter - 1;
                }
                h.put(i, counter);
            }
            for (Map.Entry<Integer, Integer> e : h.entrySet()) {
                if (e.getValue() != 0) {
                    ans = false;
                    break;
                }

            }
        } else {
            ans = false;
        }
        if (ans)
            System.out.println("Yes it is same");
        else
            System.out.println("No it is not same");
    }


    public static void main(String[] args) {
        int a[] = new int[]{2, 5, 6, 8, 10, 2, 13};
        int b[] = new int[]{2, 5, 6, 8, 10, 2, 14};
        sameSet(a, b);
    }
}
