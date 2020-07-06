package com.shefali.GraphDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFirst_unWeighted {
    int v;

    private ArrayList<ArrayList<Integer>> adj;

    public ShortestPathFirst_unWeighted(int v) {
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
    }

    public static void main(String args[]) {
        ShortestPathFirst_unWeighted g = new ShortestPathFirst_unWeighted(7);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 6);
        g.addEdge(6, 5);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.shortestPath();
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void shortestPath() {
        HashMap<Integer, DistPrev> table = new HashMap<Integer, DistPrev>();
        for (int i = 0 ; i < v ; i++)
            table.put(i, new DistPrev(-1, 0));
        int start = 2;
        int end = 6;
        thePath(start,table, end);
    }

    public void thePath(int start,HashMap<Integer, DistPrev> table, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        table.get(start).distance = 0;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(Integer i : adj.get(vertex)){
                int count_dist = table.get(i).distance;
                if(count_dist==-1){
                    table.get(i).distance = table.get(vertex).distance+1;
                    table.get(i).previous = vertex;
                    queue.offer(i);
                }
            }
        }
        System.out.println(table);
        String out = "";
        while(end != start) {
            out = end + " " + out;
            end = table.get(end).previous;
        }
        out = start + " " + out;
        System.out.println(out);
    }
}

class DistPrev {
    int distance;
    int previous;

    DistPrev(int distance, int previous) {
        this.distance = distance;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "{distance=" + distance + ",previous=" + previous + "}";
    }
}
