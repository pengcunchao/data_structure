package com.share.datastructure.api.impl;

import com.share.datastructure.api.Array;
import com.share.datastructure.api.Graph;
import com.share.datastructure.api.Queue;


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
                column.add(j, Integer.MAX_VALUE);
            }
            matrix.add(i, column);
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


    @Override
    public void DFS() {
        int ccCount = 0;
        int size = nodes.getSize();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++){
            if(!visited[i]){
                DFS(i,visited);
                ccCount ++;
            }
        }
        System.out.println(ccCount + "..................");

    }

    private void DFS(int m, boolean[] visited) {
        int size = nodes.getSize();

        visited[m] = true;
        System.out.println(m);
        for (int i = 0; i < size; i++) {
            if(matrix.get(m).get(i) != Integer.MAX_VALUE && !visited[i]){
                DFS(i,visited);
            }
        }

    }

    @Override
    public void BFS() {
        int size = nodes.getSize();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++){
            if(!visited[i]){
                BFS(i,visited);
            }
        }
    }

    private void BFS(int i, boolean[] visited) {
        int size = nodes.getSize();
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enQueue(i);
        visited[i] = true;
        Integer temp = i;
        while(!queue.isEmpty()){
            temp = queue.deQueue();
            System.out.println(temp);
            for (int j = 0; j < size; j++){
                if(matrix.get(i).get(j) != Integer.MAX_VALUE && !visited[j]){
                    queue.enQueue(j);
                    visited[j] = true;
                }
            }
        }
    }

}
