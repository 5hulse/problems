package com.shulse.leetcode;

import java.util.*;

public class Problem1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int nRows = maze.length;
        int nCols = maze[0].length;

        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        HashSet<Integer> exits = new HashSet<>();

        int idx = 0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (maze[row][col] == '.') {
                    List<Integer> coords = Arrays.asList(row, col);

                    int currIdx;
                    if (!map.containsKey(coords)) {
                        graph.add(new ArrayList<Integer>());
                        map.put(coords, idx++);
                    }

                    currIdx = map.get(coords);

                    if (row == 0 || row == nRows - 1 || col == 0 || col == nCols - 1) {
                        exits.add(currIdx);
                    }

                    List<Integer> vertex = graph.get(currIdx);

                    // Check above
                    if (row != 0 && maze[row - 1][col] == '.') {
                        // above element will already exist in the map
                        vertex.add(map.get(Arrays.asList(row - 1, col)));
                    }
                    // Check left
                    if (col != 0 && maze[row][col - 1] == '.') {
                        // left element will already exist in the map
                        vertex.add(map.get(Arrays.asList(row, col - 1)));
                    }
                    // Check right
                    if (col != nCols - 1 && maze[row][col + 1] == '.') {
                        List<Integer> rightCoords = Arrays.asList(row, col + 1);
                        if (!map.containsKey(rightCoords)) {
                            // right element will not exist in the map
                            graph.add(new ArrayList<Integer>());
                            map.put(rightCoords, idx++);
                        }
                        vertex.add(map.get(rightCoords));
                    }
                    // Check below
                    if (row != nRows - 1 && maze[row + 1][col] == '.') {
                        List<Integer> belowCoords = Arrays.asList(row + 1, col);
                        if (!map.containsKey(belowCoords)) {
                            // below element will not exist in the map
                            graph.add(new ArrayList<Integer>());
                            map.put(belowCoords, idx++);
                        }
                        vertex.add(map.get(belowCoords));
                    }
                }
            }
        }

        // BFS from starting vertex until exit found
        List<Integer> entranceList = new ArrayList<>();
        for (int i=0; i<2; i++) {
            entranceList.add(entrance[i]);
        }
        int entranceVertex = map.get(entranceList);

        if (exits.contains(entranceVertex)) {
            exits.remove(entranceVertex);
        }

        int nSteps = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Queue<Integer> nextQueue = new ArrayDeque<Integer>();
        queue.add(entranceVertex);
        boolean[] visited = new boolean[idx];
        visited[entranceVertex] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int vertex = queue.remove();
                if (exits.contains(vertex)) return nSteps;

                for (int conn: graph.get(vertex)) {
                    if (!visited[conn]) {
                        visited[conn] = true;
                        nextQueue.add(conn);
                    }
                }
            }

            queue = nextQueue;
            nextQueue = new ArrayDeque<Integer>();
            nSteps += 1;
        }

        return -1;
    }
}
