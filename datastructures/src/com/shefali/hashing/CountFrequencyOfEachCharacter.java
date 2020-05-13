package com.shefali.hashing;

import java.util.Hashtable;

public class CountFrequencyOfEachCharacter {
    public static void countFrequency(String s) {
        Hashtable<Character, Integer> h = new Hashtable();
        for (char ch : s.toCharArray()) {
            Integer counter = h.get(ch);
            if (counter == null) {
                counter = 0;
            }
            h.put(ch, ++counter);
        }
        System.out.println(h);
    }

    public static void main(String[] args) {
        countFrequency("akash");
    }
}
