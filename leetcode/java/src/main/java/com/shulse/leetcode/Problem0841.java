package com.shulse.leetcode;

import java.util.*;

public class Problem0841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() <= 1) {
            return true;
        }

        // `rooms` is provided as a graph in adjacency list format.
        // Simply perform BFS from 0 and check that all nodes are visited!
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        int nVisited = 1;
        visited[0] = true;

        while (!queue.isEmpty()) {
            List<Integer> node = rooms.get(queue.remove());
            for (int conn : node) {
                if (!visited[conn]) {
                    visited[conn] = true;
                    nVisited += 1;
                    queue.add(conn);
                }
            }
        }

        return nVisited == rooms.size();
    }
}
