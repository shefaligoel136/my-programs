package com.shefali.GraphDataStructure;

import java.util.ArrayList;
import java.util.Iterator;

public class CountAllPossiblePath {
    int v;

    private ArrayList<ArrayList<Integer>> adj;

    CountAllPossiblePath(int v){
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
    }
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    int countPaths(int s,int d,int count){
        if(s==d)
            count++;
        else{
            Iterator<Integer> i = adj.get(s).listIterator();
            while(i.hasNext()){
                int n = i.next();
                count = countPaths(n,d,count);
            }
        }
        return count;
    }


    public static void main(String args[])
    {
        CountAllPossiblePath g = new CountAllPossiblePath(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int s = 0, d = 3, count = 0;
        System.out.println(g.countPaths(s, d,count));
    }
}
