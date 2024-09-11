package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.Problem1926;

class Input1926 {
    public char[][] maze;
    public int[] entrance;

    public Input1926(char[][] maze, int[] entrance) {
        this.maze = maze;
        this.entrance = entrance;
    }
}

public class TestProblem1926 {
    Problem1926 problem = new Problem1926();

    List<Input1926> inputs = Arrays.asList(
        new Input1926(
            new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}},
            new int[]{1, 2}
        ),
        new Input1926(
            new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}},
            new int[]{1, 0}
        ),
        new Input1926(
            new char[][]{{'.', '+'}},
            new int[]{0, 0}
        ),
        new Input1926(
            new char[][]{
                {'+', '.', '+', '+', '+', '+', '+'},
                {'+', '.', '+', '.', '.', '.', '+'},
                {'+', '.', '+', '.', '+', '.', '+'},
                {'+', '.', '.', '.', '.', '.', '+'},
                {'+', '+', '+', '+', '.', '+', '.'}
            },
            new int[]{0, 1}
        )
    );

    List<Integer> outputs = Arrays.asList(1, 2, -1, 7);

    // @Test
    // public void nearestExitTest1()
    // {
    //     Input1926 input = inputs.get(0);
    //     int output = outputs.get(0);
    //     assertEquals(problem.nearestExit(input.maze, input.entrance), output);
    // }

    // @Test
    // public void nearestExitTest2()
    // {
    //     Input1926 input = inputs.get(1);
    //     int output = outputs.get(1);
    //     assertEquals(problem.nearestExit(input.maze, input.entrance), output);
    // }

    // @Test
    // public void nearestExitTest3()
    // {
    //     Input1926 input = inputs.get(2);
    //     int output = outputs.get(2);
    //     assertEquals(problem.nearestExit(input.maze, input.entrance), output);
    // }

    @Test
    public void nearestExitTest4()
    {
        Input1926 input = inputs.get(3);
        int output = outputs.get(3);
        assertEquals(problem.nearestExit(input.maze, input.entrance), output);
    }
}
