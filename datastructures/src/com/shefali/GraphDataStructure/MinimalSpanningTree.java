package com.shefali.GraphDataStructure;

import java.util.PriorityQueue;

public class MinimalSpanningTree {
    public int[][] graph;
    public int[] visited;
    public int vertices;

    public MinimalSpanningTree(int vertices) {
        graph = new int[vertices][vertices];
        visited = new int[vertices];
        this.vertices = vertices;
    }

    public static void main(String[] args) {
        MinimalSpanningTree go = new MinimalSpanningTree(7);
        go.addUnDirectedWeightedEdge(0, 2, 7);
        go.addUnDirectedWeightedEdge(2, 1, 8);
        go.addUnDirectedWeightedEdge(1, 4, 5);
        go.addUnDirectedWeightedEdge(4, 2, 7);
        go.addUnDirectedWeightedEdge(2, 3, 9);
        go.addUnDirectedWeightedEdge(0, 3, 5);
        go.addUnDirectedWeightedEdge(3, 4, 15);
        go.addUnDirectedWeightedEdge(4, 6, 9);
        go.addUnDirectedWeightedEdge(6, 5, 11);
        go.addUnDirectedWeightedEdge(5, 4, 8);
        go.addUnDirectedWeightedEdge(5, 3, 6);
        go.spanningTree();
    }

    public void addUnDirectedWeightedEdge(int v1, int v2, int w) {
        graph[v1][v2] = w;
//        graph[v2][v1] = w;
    }

    public void spanningTree() {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (graph[i][j] != 0) {
                    minHeap.offer(new HeapNode(graph[i][j], i, j));
                }
            }
        }
        while (!minHeap.isEmpty()) {
            int to = minHeap.peek().to;
            int fro = minHeap.peek().fro;
            int weight = minHeap.peek().weight;
            minHeap.poll();
            if (visited[to] == 1 && visited[fro] == 1)
                graph[to][fro] = 0;
            else {
                visited[to] = 1;
                visited[fro] = 1;
                graph[fro][to] = weight;
            }

        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class HeapNode implements Comparable<HeapNode> {
    int weight;
    int to;
    int fro;

    HeapNode(int weight, int to, int fro) {
        this.weight = weight;
        this.to = to;
        this.fro = fro;
    }

    @Override
    public int compareTo(HeapNode that) {
        return this.weight - that.weight;
    }
}
