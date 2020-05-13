package com.shefali.hashing;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubArrayWithAllOccurrencesOfaMostFrequentElement {
    public static void occurrences(int a[]){
        HashMap<Integer,Counter> h = new HashMap<Integer, Counter>();
        for(int i=0;i<a.length;i++){
            if(!h.containsKey(a[i])){
                h.put(a[i],new Counter(1,i,i));
            }
            else{
                int l_m = h.get(a[i]).leftMost;
                int count = h.get(a[i]).count;
                h.put(a[i],new Counter(count+1,l_m,i));
            }
        }
        int large_count = 1,sum = Integer.MAX_VALUE;
        int left_most = 0,right_most=0;
        for (Map.Entry<Integer,Counter> e : h.entrySet()){
            if(e.getValue().count>large_count){
                large_count = e.getValue().count;
                if(e.getValue().leftMost+e.getValue().rightMost<sum){
                    left_most = e.getValue().leftMost;
                    right_most = e.getValue().rightMost;
                }
            }
        }
        if(left_most==0&&right_most==0){
            System.out.println("Not Found!");
        }
        else{
            for(int i=left_most;i<=right_most;i++){
                System.out.println(a[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 2, 1 };
        occurrences(a);
    }
}
class Counter{
    int count;
    int leftMost;
    int rightMost;
    Counter(int count,int leftMost,int rightMost){
        this.count = count;
        this.leftMost = leftMost;
        this.rightMost = rightMost;
    }
}
