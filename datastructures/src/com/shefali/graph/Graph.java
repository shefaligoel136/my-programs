package com.shefali.graph;

import java.util.HashSet;

public class Graph {

    public int[][] graph;
    public int[] visited;
    public int vertices;

    public Graph(int vertices) {
        graph = new int[vertices][vertices];
        visited = new int[vertices];
        this.vertices = vertices;
    }

    public void addDirectedEdge(int v1, int v2) {
        graph[v1][v2] = 1;
    }

    public void addUnDirectedEdge(int v1, int v2) {
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    public void addDirectedWeightedEdge(int v1, int v2, int w) {
        graph[v1][v2] = w;
    }

    public void addUnDirectedWeightedEdge(int v1, int v2, int w) {
        graph[v1][v2] = w;
        graph[v2][v1] = w;
    }

    public void dfsTraveral(int vertex) {

    }

    public void bfsTraveral(int vertex) {
        HashSet<Integer> next = new HashSet<>();
        next.add(vertex);
        while (next.size() > 0) {
            HashSet<Integer> unvisited = new HashSet<>();
            for (int n : next) {
                System.out.println(n);
                visited[n] = 1;
                unvisited.addAll(getNextUnvisited(n));
            }
            next = unvisited;
        }
    }

    public void topologicalSort() {
        for (int i = 0; i < vertices; i++) {
            boolean hasZeroInDegree = true;
            for (int j = 0; j < vertices; j++) {
                if (graph[j][i] > 0) {
                    hasZeroInDegree = false;
                    break;
                }
            }
            if (hasZeroInDegree) {
                System.out.println(i);
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = 0;
                }
            }
        }
    }

    private HashSet<Integer> getNextUnvisited(int vertex) {
        HashSet<Integer> nextVertices = new HashSet<>();
        for (int i = 0; i < vertices; i++) {
            if (graph[vertex][i] > 0 && visited[i] != 1) {
                nextVertices.add(i);
            }
        }
        return nextVertices;
    }

    public void resetVisited() {
        visited = new int[vertices];
    }

        public static void main(String[] args) {
            Graph go = new Graph(5);
            go.addDirectedEdge(0,1);
            go.addDirectedEdge(0,2);
            go.addDirectedEdge(1,4);
            go.addDirectedEdge(4,2);
            go.addDirectedEdge(2,3);
            go.addDirectedEdge(3,0);

            go.bfsTraveral(0);
    }
}
