package com.shulse.leetcode;

import java.util.*;

public class Problem0547 {
    public int firdCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int result = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, isConnected, visited);
                result += 1;
            }
        }

        return result;
    }

    void bfs(int start, int[][] isConnected, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int idx = queue.remove();
            int[] row = isConnected[idx];
            for (int i=0; i<isConnected.length; i++) {
                if (!visited[i] && row[i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
