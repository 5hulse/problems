package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem1448;

public class TestProblem1448 {
    Problem1448 problem = new Problem1448();

    // Using -1 as `null`
    List<Integer[]> inputArrays= Arrays.asList(
        new Integer[]{3, 1, 4, 3, -1, 1, 5},
        new Integer[]{3, 3, -1, 4, 2},
        new Integer[]{1}
    );
    List<Integer> outputs = Arrays.asList(4, 3, 1);

    @Test
    public void goodNodesTest()
    {
        for (int i=0; i<inputArrays.size(); i++) {
            TreeNode root = new TreeNode(inputArrays.get(i), -1);
            int output = outputs.get(i);
            int result = problem.goodNodes(root);
            assertEquals(output, result);
        }
    }
}
