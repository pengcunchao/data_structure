package com.share.datastructure.api.impl;

import com.share.datastructure.api.Array;
import com.share.datastructure.api.Graph;

public class DenseGraph<T> implements Graph<T> {
    private Array<T> nodes;
    private Array<Array<Integer>> matrix;
    private int edges;

    public DenseGraph(Array<T> nodes) {
        this.nodes = nodes;
        this.edges = 0;
        int size = nodes.getSize();
        matrix = new DynamicArray<>(size);
        for (int i = 0; i < size; i++) {
            Array<Integer> column = new DynamicArray<>(size);
            for (int j = 0; j < size; j++) {
                column.set(j, Integer.MAX_VALUE);
            }
            matrix.set(i, column);
        }
    }

    @Override
    public void addEdge(int n, int m, int weight) {
        if(matrix.get(n).get(m) == Integer.MAX_VALUE){
            edges ++;
        }
        matrix.get(n).set(m,weight);
    }

    @Override
    public int getWeight(int n, int m) {
        return matrix.get(n).get(m);
    }
}
