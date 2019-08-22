package com.shefali.graph;

import java.util.ArrayList;

public interface GraphOperations {
    public void dfsTraveral(GraphNode gn);
    public void bfsTraveral(ArrayList<GraphNode> queue);
    public void topologicalSort(GraphNode gn);
}
