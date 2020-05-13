package com.shefali.hashing;

import java.util.Hashtable;
import java.util.Map;

public class MinimumIndexSumforCommonElements {
    public static void find(String a[],String b[]){
        int min = a.length+b.length-2;
        String s = " ";
        Hashtable<String,SelfNode> h = new Hashtable<>();
        for(int i = 0;i<a.length;i++){
            if(!h.containsKey(a[i])){
                h.put(a[i],new SelfNode(i,1));
            }
        }
        for(int i = 0;i<b.length;i++){
            if(h.containsKey(b[i])){
                Integer count = h.get(b[i]).first_index;
                Integer count1 = h.get(b[i]).next_index;
                h.put(b[i],new SelfNode(count+i,2));
            }
        }
        for (Map.Entry<String, SelfNode> e : h.entrySet()) {
            if (e.getValue().first_index<min && e.getValue().next_index==2) {
                min = e.getValue().first_index;
                s = e.getKey();
            }
        }
        System.out.println(s+" "+min);
    }

    public static void main(String[] args) {
        String a[] = {"GeeksforGeeks","Udemy","Coursera","edX"};
        String b[] = {"Codecademy","Khan Academy","GeeksforGeeks"};
        find(a,b);
    }
}
