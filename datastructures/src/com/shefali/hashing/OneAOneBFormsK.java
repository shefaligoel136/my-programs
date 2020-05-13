package com.shefali.hashing;

import java.util.Hashtable;

public class OneAOneBFormsK {
    public static void checkK(int a[], int b[], int k) {
        boolean check = false;
        Hashtable<Integer, Integer> h = new Hashtable<>();
        for (int i : a) {
            h.put(i, k - i);
        }
        for (int i : b) {
            if (h.containsValue(i)) {
                System.out.println(i);
                check = true;
            }
        }
        if(check==false)
            System.out.println("no such pair");
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 5, 15, 6};
        int b[] = new int[]{4, 15, 5};
        int k = 20;
        if (a.length > b.length)
            checkK(b, a, k);
        else
            checkK(a, b, k);
    }
}
