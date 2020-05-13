package com.shefali.hashing;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWithinKdistance {
    public static void duplicate(int a[],int k){
        HashMap<Integer,SelfNode> h = new HashMap<>();
        boolean flag = false;
        for(int i = 0;i<a.length;i++){
            if(!h.containsKey(a[i])){
                h.put(a[i],new SelfNode(i,0));
            }
            else{
                int check = h.get(a[i]).first_index;
                if (i-check<=k) {
                    h.replace(a[i],new SelfNode(i,1));
                }
            }
        }
        for (Map.Entry<Integer,SelfNode> e : h.entrySet()) {
            if(e.getValue().next_index>=1){
                System.out.println("The value is: "+e.getKey()+" which is repeated at "+ e.getValue().first_index);
                flag = true;
            }
        }
        if(!flag)
            System.out.println("No such value is present");
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 1, 2, 3, 4};
        duplicate(a,3);
        int b[] = new int[]{10, 5, 3, 4, 3, 5, 6};
        duplicate(b,3);
    }
}
