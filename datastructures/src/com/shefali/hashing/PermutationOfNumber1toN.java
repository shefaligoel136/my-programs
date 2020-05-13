package com.shefali.hashing;

import java.util.HashMap;

public class PermutationOfNumber1toN {
    public static void pn1toN(int a[]){
        int n = a.length,missing_no=1;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!h.containsKey(a[i])&&a[i]<=n){
                h.put(a[i],i);
                while(h.containsKey(missing_no)||a[i]==missing_no){
                    missing_no = missing_no+1;
                }
            }
            else{
                if(!h.containsKey(missing_no)){
                    h.put(missing_no,i);
                    missing_no = missing_no+1;
                }
            }
        }
        System.out.println(h.keySet());
    }

    public static void main(String[] args) {
        int A[] = { 11,2,76,4,5,9,13,54,2 };
        pn1toN(A);
    }
}
