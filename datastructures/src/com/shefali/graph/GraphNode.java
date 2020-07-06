package com.shefali.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    Integer data;
    ArrayList<GraphNode> childs; // telling java that the list is of type GraphNode

    GraphNode(Integer data)
    {
        this.data = data;
        this.childs = new ArrayList<GraphNode>();
    }
}
