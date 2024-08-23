package com.graph.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjansAlgo {
    int v;
    List<List<Integer>> adj = new ArrayList<>();

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    TarjansAlgo(int v) {
        this.v = v;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        TarjansAlgo g1 = new TarjansAlgo(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("SSC in first graph ");
        g1.SCC();
/*
        TarjansAlgo g2 = new TarjansAlgo(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        System.out.println("\nSSC in second graph ");
        g2.SCC();

        TarjansAlgo g3 = new TarjansAlgo(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        System.out.println("\nSSC in third graph ");
        g3.SCC();

        TarjansAlgo g4 = new TarjansAlgo(11);
        g4.addEdge(0, 1);
        g4.addEdge(0, 3);
        g4.addEdge(1, 2);
        g4.addEdge(1, 4);
        g4.addEdge(2, 0);
        g4.addEdge(2, 6);
        g4.addEdge(3, 2);
        g4.addEdge(4, 5);
        g4.addEdge(4, 6);
        g4.addEdge(5, 6);
        g4.addEdge(5, 7);
        g4.addEdge(5, 8);
        g4.addEdge(5, 9);
        g4.addEdge(6, 4);
        g4.addEdge(7, 9);
        g4.addEdge(8, 9);
        g4.addEdge(9, 8);
        System.out.println("\nSSC in fourth graph ");
        g4.SCC();

        TarjansAlgo g5 = new TarjansAlgo(5);
        g5.addEdge(0, 1);
        g5.addEdge(1, 2);
        g5.addEdge(2, 3);
        g5.addEdge(2, 4);
        g5.addEdge(3, 0);
        g5.addEdge(4, 2);
        System.out.println("\nSSC in fifth graph ");
        g5.SCC();*/
    }

    int step = 0;

    private void SCC() {
        int[] disc = new int[v];
        int[] low = new int[v];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, stack);
            }
        }

    }

    private void dfs(int u, int[] disc, int[] low, Stack<Integer> stack) {
        disc[u] = low[u] = step;
        step++;
        stack.push(u);
        adj.get(u).forEach(v -> {
            if (disc[v] == -1) {
                dfs(v, disc, low, stack);
                low[u] = Math.min(low[u], low[v]);
            } else if (stack.contains(v)) {
                low[u] = Math.min(low[u], disc[v]);
            }
        });

        if(low[u]==disc[u]){
            while(!stack.isEmpty() && stack.peek()!=low[u]){
                System.out.print(stack.pop()+" ");
            }
            System.out.print(stack.pop());
            System.out.println();
        }

    }


}
