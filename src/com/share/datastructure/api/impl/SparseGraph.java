package com.share.datastructure.api.impl;

import com.share.datastructure.api.Array;
import com.share.datastructure.api.Graph;

import java.util.LinkedList;
import java.util.List;

public class SparseGraph<T> implements Graph<T> {
    private Array<T> nodes;
    private Array<List<Edge>> edgeList;
    private int edges;


    public SparseGraph(Array<T> nodes) {
        this.nodes = nodes;
        this.edges = 0;
        edgeList = new DynamicArray<>(nodes.getSize());
        for (int i = 0; i < nodes.getSize(); i++) {
            edgeList.set(i, new LinkedList<>());
        }
    }

    @Override
    public void addEdge(int n, int m, int weight) {
        Edge edge = find(n, m);
        if (edge != null) {
            edge.weight = weight;
        } else {
            edgeList.get(n).add(new Edge(m, weight));
            edges++;
        }

    }

    @Override
    public int getWeight(int n, int m) {
        Edge edge = find(n, m);
        return edge == null ? Integer.MAX_VALUE : edge.weight;
    }

    private Edge find(int n, int m) {
        List<Edge> edges = edgeList.get(n);
        for (Edge edge : edges) {
            if (edge.nodeIndex == m) {
                return edge;
            }
        }
        return null;
    }

    private class Edge {
        private int nodeIndex;
        private int weight;

        public Edge(int nodeIndex, int weight) {
            this.nodeIndex = nodeIndex;
            this.weight = weight;
        }
    }
}
