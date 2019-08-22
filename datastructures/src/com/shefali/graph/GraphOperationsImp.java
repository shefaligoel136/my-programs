package com.shefali.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphOperationsImp implements GraphOperations {

    public static void main(String[] args) {
        GraphNode five = new GraphNode(5);
        GraphNode six = new GraphNode(6);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        three.childs.add(six);
        two.childs.add(three);
        two.childs.add(five);
        one.childs.add(two);
        one.childs.add(four);
        //four.childs.add(two);
        GraphOperationsImp graphOperationsImp = new GraphOperationsImp();
        ArrayList<GraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(one);
        graphOperationsImp.bfsTraveral(graphNodes);
        System.out.println();
        graphOperationsImp.dfsTraveral(one);
    }

    @Override
    public void dfsTraveral(GraphNode gn) {
        if (gn != null) {
            System.out.print(gn.data + " ");
            for (GraphNode child : gn.childs) {
                dfsTraveral(child);
            }
        }
    }

    @Override
    public void bfsTraveral(ArrayList<GraphNode> queue) {
        if (queue.size() != 0) {
            ArrayList<GraphNode> q = new ArrayList<>();
            for (GraphNode gn : queue) {
                System.out.print(gn.data + " ");
                q.addAll(gn.childs);
            }
            bfsTraveral(q);
        }
    }

    @Override
    public void topologicalSort(GraphNode gn) {

    }
}
