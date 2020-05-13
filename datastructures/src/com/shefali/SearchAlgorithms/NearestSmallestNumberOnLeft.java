package com.shefali.SearchAlgorithms;

import java.util.Stack;

public class NearestSmallestNumberOnLeft {
    public static void findNum(int arr[]){
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<arr.length;i++){
           while(!s.isEmpty()&&s.peek()>=arr[i]){
               s.pop();
           }
           if(s.isEmpty()){
               System.out.print("_"+", ");
           }
           else{
               System.out.print(s.peek()+", ");
           }
           s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 0, 2, 5};
        findNum(arr);
    }
}
