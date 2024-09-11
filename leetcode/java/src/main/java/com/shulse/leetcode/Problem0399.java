package com.shulse.leetcode;

import java.util.*;

class GraphEntry {
    int vertex;
    double value;

    public GraphEntry(int vertex, double value) {
        this.vertex = vertex;
        this.value = value;
    }
}


public class Problem0399 {
    public double[] calcEquation (List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<List<GraphEntry>> graph = new ArrayList<>();
        // lookup table that maps strings to graph location
        HashMap<String, Integer> lookup = new HashMap<>();
        int currIdx = 0;
        for (int i = 0; i < values.length; i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double value = values[i];
            if (!lookup.containsKey(numerator)) {
                lookup.put(numerator, currIdx);
                graph.add(new ArrayList<GraphEntry>());
                currIdx++;
            }
            if (!lookup.containsKey(denominator)) {
                lookup.put(denominator, currIdx);
                graph.add(new ArrayList<GraphEntry>());
                currIdx++;
            }

            int numeratorIdx = lookup.get(numerator);
            int denominatorIdx = lookup.get(denominator);
            graph.get(numeratorIdx).add(new GraphEntry(denominatorIdx, value));
            graph.get(denominatorIdx).add(new GraphEntry(numeratorIdx, 1.0 / value));
        }
        int nVertices = currIdx;

        int nQueries = queries.size();
        double[] result = new double[nQueries];
        for (int i = 0; i < nQueries; i++) {
            result[i] = -1.0;

            List<String> query = queries.get(i);
            Integer start = lookup.get(query.get(0));
            Integer stop = lookup.get(query.get(1));

            if (start != null && stop != null) {
                // DFS to find the stop node while keeping track of the path "size"
                boolean[] visited = new boolean[nVertices];
                Double value = dfs(graph, start, stop, visited, 1.0);
                if (value != null) {
                    result[i] = value;
                }
            }
        }

        return result;
    }

    Double dfs(List<List<GraphEntry>> graph, int start, int stop, boolean[] visited, double pathSize) {
        if (start == stop) {
            return pathSize;
        }
        visited[start] = true;
        List<GraphEntry> startNode = graph.get(start);
        for (GraphEntry conn : startNode) {
            if (!visited[conn.vertex]) {
                Double val = dfs(graph, conn.vertex, stop, visited, pathSize * conn.value);
                if (val != null) {
                    return val;
                }
            }
        }
        return null;
    }
}
