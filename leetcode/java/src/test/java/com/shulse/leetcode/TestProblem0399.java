package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0399;


class Input {
    List<List<String>> equations;
    double[] values;
    List<List<String>> queries;

    Input(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.equations = equations;
        this.values = values;
        this.queries = queries;
    }
}

public class TestProblem0399 {
    Problem0399 problem = new Problem0399();

    List<Input> inputs = Arrays.asList(
        new Input(
            Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
            ),
            new double[]{2.0, 3.0},
            Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
            )
        ),
        new Input(
            Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("bc", "cd")
            ),
            new double[]{1.5, 2.5, 5.0},
            Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("c", "b"),
                Arrays.asList("bc", "cd"),
                Arrays.asList("cd", "bc")
            )
        ),
        new Input(
            Arrays.asList(
                Arrays.asList("a", "b")
            ),
            new double[]{0.5},
            Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "c"),
                Arrays.asList("x", "y")
            )
        )
    );

    List<double[]> outputs = Arrays.asList(
        new double[]{6.0, 0.5, -1.0, 1.0, -1.0},
        new double[]{3.75, 0.4, 5.0, 0.2},
        new double[]{0.5, 2.0, -1.0, -1.0}
    );

    @Test
    public void calcEquationTest1()
    {
        Input input = inputs.get(0);
        double[] output = outputs.get(0);
        assertArrayEquals(problem.calcEquation(input.equations, input.values, input.queries), output, 1.0e-10);
    }

    @Test
    public void calcEquationTest2()
    {
        Input input = inputs.get(1);
        double[] output = outputs.get(1);
        assertArrayEquals(problem.calcEquation(input.equations, input.values, input.queries), output, 1.0e-10);
    }

    @Test
    public void calcEquationTest3()
    {
        Input input = inputs.get(2);
        double[] output = outputs.get(2);
        assertArrayEquals(problem.calcEquation(input.equations, input.values, input.queries), output, 1.0e-10);
    }
}
