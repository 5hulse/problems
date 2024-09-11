package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem1161;

public class TestProblem1161 {
    Problem1161 problem = new Problem1161();

    // Using -1 as `null`
    List<TreeNode> roots = Arrays.asList(
        new TreeNode(new Integer[]{1, 7, 0, 7, -8, -1, -1}, -1),
        new TreeNode(new Integer[]{989, 0, 10250, 98693, -89388, 0, 0, 0, -32127},  0)
    );

    List<Integer> outputs = Arrays.asList(2, 2);

    @Test
    public void maxLevelSumTest()
    {
        for (int i = 0; i < roots.size(); i++) {
            TreeNode input = roots.get(i);
            int output = outputs.get(i);
            int result = problem.maxLevelSum(input);
            assertEquals(result, output);
        }
    }
}
