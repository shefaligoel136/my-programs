package com.shefali.GraphDataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class TopologicalSort_HashNSet {
    int v;

    private ArrayList<ArrayList<Integer>> adj;

    public TopologicalSort_HashNSet(int v) {
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
    }

    public static void main(String args[]) {
        TopologicalSort_HashNSet g = new TopologicalSort_HashNSet(6);
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

    void topologicalSortUtil(int v, HashSet<Integer> visited,
                             Stack<Integer> stack) {
        visited.add(v);
        for (Integer i : adj.get(v)) {
            if (!visited.contains(i))
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < v; i++)
            if (!visited.contains(i))
                topologicalSortUtil(i, visited, stack);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}

