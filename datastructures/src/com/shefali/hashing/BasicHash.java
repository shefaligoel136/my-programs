package com.shefali.hashing;

import java.util.HashMap;
import java.util.Map;

public class BasicHash {
    public static void main(String[] args) {
        Map<Integer, String> rollToStudent = new HashMap<>();
        rollToStudent.put("Akash Goel".hashCode(), "Akash Goel");
        rollToStudent.put("Shefali Goel".hashCode(), "Shefali Goel");

        System.out.println(rollToStudent.containsKey("Shefali Goel".hashCode()));
        System.out.println(rollToStudent.containsValue("Shefali Goel"));
        for(Map.Entry<Integer, String> e : rollToStudent.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println(rollToStudent.get("Akash Goel".hashCode()));
    }
}
