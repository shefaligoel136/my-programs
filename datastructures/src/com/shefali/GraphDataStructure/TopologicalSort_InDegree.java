package com.shefali.GraphDataStructure;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort_InDegree {
    int v;

    private ArrayList<ArrayList<Integer>> adj;

    public TopologicalSort_InDegree(int v) {
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
    }

    public static void main(String args[]) {
        TopologicalSort_InDegree g = new TopologicalSort_InDegree(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 5);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSort() {
        HashMap<Integer, Integer> inDegree = calculateInDegree();
        List<Integer> zeroIndegrees = inDegree.entrySet().stream().filter(e -> e.getValue() == 0).map(e -> e.getKey()).collect(Collectors.toList());
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(zeroIndegrees);
        while (!queue.isEmpty()) {
            for(Integer i : adj.get(queue.peek())) {
                inDegree.put(i, inDegree.get(i) - 1);
                if(inDegree.get(i) == 0) {
                    queue.add(i);
                }
            }
            System.out.print(queue.poll() + " ");
        }
    }

    private HashMap<Integer, Integer> calculateInDegree() {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < v; i++) {
            inDegree.put(i, 0);
        }
        for (int i = 0; i < v; i++) {
            for (int j : adj.get(i)) {
                inDegree.put(j, inDegree.get(j) + 1);
            }
        }
        return inDegree;
    }
}