package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0104;

public class TestProblem0104 {
    Problem0104 problem = new Problem0104();

    // Using -1 as `null`
    List<Integer[]> inputArrays = Arrays.asList(
        new Integer[]{3, 9, 20, -1, -1, 15, 7},
        new Integer[]{1, -1, 2}
    );

    List<Integer> outputs = Arrays.asList(3, 2);

    @Test
    public void maxDepthTest()
    {
        for (int i = 0; i < inputArrays.size(); i++) {
            TreeNode input = new TreeNode(inputArrays.get(i), -1);
            int output = outputs.get(i);
            int result = problem.maxDepth(input);
            assertEquals(result, output);
        }
    }
}
