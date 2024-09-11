package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0437;

public class TestProblem0437 {
    Problem0437 problem = new Problem0437();

    // Using 0 as `null`
    List<Integer[]> inputArrays= Arrays.asList(
        new Integer[]{10, 5, -3, 3, 2, 0, 11, 3, -2, 0, 1},
        new Integer[]{5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1},
        new Integer[]{1000000000, 1000000000, 0, 294967296, 0, 1000000000, 0, 1000000000, 0, 1000000000}
    );
    List<Integer> targetSums = Arrays.asList(8, 22, 0);
    List<Integer> outputs = Arrays.asList(3, 3, 0);

    @Test
    public void goodNodesTest()
    {
        for (int i=0; i<inputArrays.size(); i++) {
            TreeNode root = new TreeNode(inputArrays.get(i), 0);
            int targetSum = targetSums.get(i);
            int output = outputs.get(i);
            int result = problem.pathSum(root, targetSum);
            assertEquals(output, result);
        }
    }
}
