package com.shulse.leetcode;

import java.util.*;

class Edge {
    public int value;
    public int node;

    public Edge(int value, int node) {
        this.value = value;
        this.node = node;
    }
}

public class Problem1466 {
    public int minReorder(int n, int[][] connections) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < n - 1; i++) {
            int src = connections[i][0];
            int dst = connections[i][1];
            graph.get(src).add(new Edge(1, dst));
            graph.get(dst).add(new Edge(0, src));
        }

        boolean[] visited = new boolean[n];
        int nChanges = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (Edge edge : graph.get(node)) {
                if (!visited[edge.node]) {
                    visited[edge.node] = true;
                    nChanges += edge.value;
                    queue.add(edge.node);
                }
            }
        }

        return nChanges;
    }
}
