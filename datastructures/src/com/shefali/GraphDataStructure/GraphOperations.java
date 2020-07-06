package com.shefali.GraphDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    public int label;
    public boolean wasVisited;

    public Vertex(int lab) {
        label = lab;
        wasVisited = false;
    }
}

public class GraphOperations {
    public int[][] adjMat;
    public int[] visitedTable;
    public int vertices;


    public GraphOperations(int vertices) {
        visitedTable = new int[vertices];
        adjMat = new int[vertices][vertices];
        this.vertices = vertices;
    }

    public void addDirectedEdge(int v1, int v2) {
        adjMat[v1][v2] = 1;
    }

    public void addUnDirectedEdge(int v1, int v2) {
        adjMat[v1][v2] = 1;
        adjMat[v2][v1] = 1;
    }

    public void addDirectedWeightedEdge(int v1, int v2, int w) {
        adjMat[v1][v2] = w;
    }

    public void addUnDirectedWeightedEdge(int v1, int v2, int w) {
        adjMat[v1][v2] = w;
        adjMat[v2][v1] = w;
    }

    public void displayVertex(int v) {
        System.out.print(v);
    }

    public void reset(){
        for(int i=0;i<vertices;i++)
            visitedTable[i] = 0;
    }

    public void depthFirstTraversal(int vertex) {
        Stack<Integer> s = new Stack<>();
        s.push(vertex);
        visitedTable[vertex] = 1;
        displayVertex(vertex);
        while(!s.isEmpty()){
            int check = getAdjUnvisitedVertex(s.peek());
            if(check==-1)
                s.pop();
            else {
                visitedTable[check] = 1;
                displayVertex(check);
                s.push(check);
            }
        }
    }

    public void breadthFirstTraversal(int vertex) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(vertex);
        visitedTable[vertex] = 1;
        displayVertex(vertex);

        int check;

        while (!q.isEmpty()) {
            int v = q.poll();
            while ((check = getAdjUnvisitedVertex(v)) != -1) {
                visitedTable[check] = 1;
                displayVertex(check);
                q.offer(check);
            }
        }

    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < vertices; j++) {
            if (adjMat[v][j] == 1 && visitedTable[j] == 0)
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphOperations go = new GraphOperations(5);
        go.addDirectedEdge(0,1);
        go.addDirectedEdge(0,2);
        go.addDirectedEdge(1,4);
        go.addDirectedEdge(4,2);
        go.addDirectedEdge(2,3);
        go.addDirectedEdge(3,0);

        //go.breadthFirstTraversal(0);
        //go.reset();
        //System.out.println();
        go.depthFirstTraversal(0);
    }
}
