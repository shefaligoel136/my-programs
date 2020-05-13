package com.shefali.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumDistanceOfTwoOccurance {
    public static void maxDistance(int a[]){
        HashMap<Integer,SelfNode> h = new HashMap<>();
        for(int i = 0 ;i<a.length;i++){
            if(!h.containsKey(a[i])){
                h.put(a[i],new SelfNode(i,0));
            }
            else{
                SelfNode old_i = h.get(a[i]);
                h.replace(a[i], new SelfNode(old_i.first_index,i));

            }
        }
        for (Map.Entry<Integer,SelfNode> e : h.entrySet()) {
            if (e.getValue().next_index != 0) {
                System.out.println("The No is "+ e.getKey()+" and the maximum distance b/w the duplicate is: "+(e.getValue().next_index-e.getValue().first_index));
            }

        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        maxDistance(a);
    }
}

