package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.Problem0547;


public class TestProblem0547 {
    Problem0547 problem = new Problem0547();

    List<int[][]> inputs = Arrays.asList(
        new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
        new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}
    );
    List<Integer> outputs = Arrays.asList(2, 3);

    @Test
    public void firdCircleNumTest1()
    {
        int[][] isConnected = inputs.get(0);
        int output = outputs.get(0);
        assertEquals(problem.firdCircleNum(isConnected), output);
    }

    @Test
    public void firdCircleNumTest2()
    {
        int[][] isConnected = inputs.get(1);
        int output = outputs.get(1);
        assertEquals(problem.firdCircleNum(isConnected), output);
    }
}
