package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.Problem1466;

class Input1466 {
    int n;
    int[][] connections;

    public Input1466(int n, int[][] connections) {
        this.n = n;
        this.connections = connections;
    }
}

public class TestProblem1466 {
    Problem1466 problem = new Problem1466();

    List<Input1466> inputs = Arrays.asList(
        new Input1466(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}),
        new Input1466(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}),
        new Input1466(3, new int[][]{{1, 0}, {2, 0}})
    );

    List<Integer> outputs = Arrays.asList(3, 2, 0);

    @Test
    public void minReorderTest1()
    {
        Input1466 input = inputs.get(0);
        int output = outputs.get(0);
        assertEquals(problem.minReorder(input.n, input.connections), output);
    }

    @Test
    public void minReorderTest2()
    {
        Input1466 input = inputs.get(1);
        int output = outputs.get(1);
        assertEquals(problem.minReorder(input.n, input.connections), output);
    }

    @Test
    public void minReorderTest3()
    {
        Input1466 input = inputs.get(2);
        int output = outputs.get(2);
        assertEquals(problem.minReorder(input.n, input.connections), output);
    }
}
