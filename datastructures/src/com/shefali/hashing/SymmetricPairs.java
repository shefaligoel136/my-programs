package com.shefali.hashing;

import java.util.HashMap;

public class SymmetricPairs {
    public static void symmetricPairs(int a[][]){
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<a.length;i++){
            int first = a[i][0];
            int second = a[i][1];
            if(h.get(second)!=null &&h.get(second)==first){
                System.out.println(first+" "+second);
            }
            else{
                h.put(first,second);
            }

        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[5][2];
        arr[0][0] = 11; arr[0][1] = 20;
        arr[1][0] = 30; arr[1][1] = 40;
        arr[2][0] = 5;  arr[2][1] = 10;
        arr[3][0] = 40;  arr[3][1] = 30;
        arr[4][0] = 10;  arr[4][1] = 5;
        symmetricPairs(arr);
    }
}
