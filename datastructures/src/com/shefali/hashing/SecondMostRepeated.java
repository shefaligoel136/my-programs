package com.shefali.hashing;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SecondMostRepeated {
    public static void repeated(String a[]) {
        String ss = "";
        Hashtable<String, Integer> h = new Hashtable<>();
        for (String s : a) {
            if (!h.containsKey(s)) {
                h.put(s, 1);
            } else {
                int count = h.get(s);
                h.put(s, count + 1);
            }
        }
        int largest = 0, second_largest = 0;
        String large = null, second_large = null;
        for (Map.Entry<String, Integer> e : h.entrySet()) {
//            System.out.println(e.getKey() + " " + e.getValue());
            if (e.getValue() >= largest) {
                second_largest = largest;
                largest = e.getValue();
                second_large = large;
                large = e.getKey();
//                System.out.println(ss + " " + second_largest);
            } else if (e.getValue() >= second_largest) {
                second_largest = e.getValue();
                second_large = e.getKey();
//                System.out.println(ss + " " + second_largest);
            }
        }
        System.out.println(second_large);
    }


    public static void main(String[] args) {
        String arr[] = {"ccc", "aaa", "ccc", "ddd", "aaa", "aaa", "ccc", "ccc"};
        repeated(arr);
    }
}
