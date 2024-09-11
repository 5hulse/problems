package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem1372;

public class TestProblem1372 {
    // Using 0 as `null`
    List<Integer[]> inputArrays = Arrays.asList(
        new Integer[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1},
        new Integer[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1},
        new Integer[]{1}
    );
    List<Integer> outputs = Arrays.asList(3, 4, 0);

    @Test
    public void longestZigZagTest()
    {
        Problem1372 problem;
        for (int i = 0; i < inputArrays.size(); i++) {
            problem = new Problem1372();
            TreeNode input = new TreeNode(inputArrays.get(i), 0);
            int output = outputs.get(i);
            int result = problem.longestZigZag(input);
            assertEquals(result, output);
        }
    }
}
