package com.shefali.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void repetition(String s) {
        boolean check1 = false, check2 = false;
        Map<Character, Integer> h = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            Integer counter = h.get(ch);
            if (counter == null) {
                counter = 0;
            } else {
                counter = counter + 1;
            }
            h.put(ch, counter);
        }
        for (Map.Entry<Character, Integer> e : h.entrySet()) {
            if (e.getValue() == 0) {
                System.out.println("The first character not repeated is: " + e.getKey());
                check1 = true;
                break;
            }
        }
        for (Map.Entry<Character, Integer> e : h.entrySet()) {
            if (e.getValue() > 0) {
                System.out.println("The first character that is repeated is: " + e.getKey());
                check2 = true;
                break;
            }
        }
        if (check1 == false) {
            System.out.println("All the characters are repeated");
        }
        if (check2 == false) {
            System.out.println("No character is repeated");
        }
    }

    public static void main(String[] args) {
        repetition("abzddab");
    }
}
