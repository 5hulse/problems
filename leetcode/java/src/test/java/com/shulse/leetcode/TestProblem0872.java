package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0872;

public class TestProblem0872 {
    Problem0872 problem = new Problem0872();

    // Using -1 as `null`
    List<Integer[]> root1Arrays = Arrays.asList(
        new Integer[]{3, 5, 1, 6, 2, 9, 8, -1, -1, 7, 4},
        new Integer[]{1, 2, 3}
    );
    List<Integer[]> root2Arrays = Arrays.asList(
        new Integer[]{3, 5, 1, 6, 7, 4, 2, -1, -1, -1, -1, -1, -1, 9, 8},
        new Integer[]{1, 3, 2}
    );
    List<Boolean> outputs = Arrays.asList(true, false);

    @Test
    public void maxDepthTest()
    {
        for (int i=0; i<root1Arrays.size(); i++) {
            TreeNode root1 = new TreeNode(root1Arrays.get(i), -1);
            TreeNode root2 = new TreeNode(root2Arrays.get(i), -1);
            boolean output = outputs.get(i);
            boolean result = problem.leafSimilar(root1, root2);
            assertEquals(output, result);
        }
    }
}
