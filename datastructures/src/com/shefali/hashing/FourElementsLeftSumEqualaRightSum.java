package com.shefali.hashing;

import java.util.*;

public class FourElementsLeftSumEqualaRightSum {
    public static void findPairs(int arr[]) {
        Hashtable<Integer, List<SelfNode>> h = new Hashtable<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                if(!h.containsKey(sum)){
                    List<SelfNode> l = new ArrayList<>();
                    l.add(new SelfNode(arr[i],arr[j]));
                    h.put(sum,l);
                }
                else{
                    List<SelfNode> selfNodes = h.get(sum);
                    selfNodes.add(new SelfNode(arr[i],arr[j]));
                }
            }
        }
        for(Map.Entry<Integer,List<SelfNode>> e : h.entrySet()) {
            int val = e.getValue().size();
            //System.out.println(val+" "+e.getKey());
            if(val>=2) {
                System.out.println("For the value: "+e.getKey() + " "+ "the pairs are as follows:");
                for(SelfNode ele:e.getValue()){
                    System.out.println("("+ele.first_index+","+ele.next_index+")");
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        findPairs(arr);
    }
}
