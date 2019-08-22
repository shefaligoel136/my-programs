package com.shefali.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int data;
    ArrayList<GraphNode> childs; // telling java that the list is of type GraphNode

    GraphNode(int data)
    {
        this.data = data;
        this.childs = new ArrayList<GraphNode>();
    }
}
