package com.shefali.hashing;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicateFromString {
    public static void removeDuplicate(String s){
        Map<Character,Boolean> h=new LinkedHashMap<>();
        for(char ch: s.toCharArray()){
            if(!h.containsKey(ch)){
                h.put(ch,true);
            }
        }
        for(char ch:h.keySet()){
            System.out.print(ch);
        }
    }
    public static void main(String[] args) {
        removeDuplicate("akash");
    }
}
