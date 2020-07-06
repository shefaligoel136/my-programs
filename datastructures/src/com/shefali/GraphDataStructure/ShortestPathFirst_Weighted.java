package com.shefali.GraphDataStructure;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ShortestPathFirst_Weighted {
    public int[][] graph;
    public int[] visited;
    public int vertices;

    public ShortestPathFirst_Weighted(int vertices) {
        graph = new int[vertices][vertices];
        visited = new int[vertices];
        this.vertices = vertices;
    }

    public static void main(String[] args) {
        ShortestPathFirst_Weighted go = new ShortestPathFirst_Weighted(5);
        go.addDirectedWeightedEdge(0, 1, 4);
        go.addDirectedWeightedEdge(0, 2, 1);
        go.addDirectedWeightedEdge(1, 4, 4);
        go.addDirectedWeightedEdge(2, 1, 2);
        go.addDirectedWeightedEdge(2, 3, 4);
        go.addDirectedWeightedEdge(3, 4, 4);
        go.shortestPath(0, 4);
    }

    public void addDirectedWeightedEdge(int v1, int v2, int w) {
        graph[v1][v2] = w;
    }

    public void shortestPath(int start, int end) {
        HashMap<Integer, DistPrevWeighted> table = new HashMap<>();
        for (int i = 0; i < vertices; i++)
            table.put(i, new DistPrevWeighted(0, 0));
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        table.get(start).distance = 0;


        while (!queue.isEmpty()) {
            int vertex = queue.poll().vertex;
            for (Integer i = 0; i < vertices; i++) {
                if (graph[vertex][i] == 0) {
                    continue;
                }
                boolean found = false;
                Node existingNode = null;
                for (Node n : queue) {
                    if (n.vertex == i) {
                        found = true;
                        existingNode = n;
                        break;
                    }
                }
                int newDistance = table.get(vertex).distance + graph[vertex][i];
                if (found) {
                    if (existingNode.distance > newDistance) {
                        queue.remove(existingNode);
                        queue.offer(new Node(i, newDistance));
                        table.get(i).distance = newDistance;
                        table.get(i).previous = vertex;
                    }
                } else {
                    queue.offer(new Node(i, newDistance));
                    table.get(i).distance = newDistance;
                    table.get(i).previous = vertex;
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

class DistPrevWeighted {
    int distance;
    int previous;

    DistPrevWeighted(int distance, int previous) {
        this.distance = distance;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "{distance=" + distance + ",previous=" + previous + "}";
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node that) {
        return this.distance - that.distance;
    }
}
