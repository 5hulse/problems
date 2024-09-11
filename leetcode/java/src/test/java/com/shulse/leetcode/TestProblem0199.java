package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0199;

public class TestProblem0199 {

    List<TreeNode> roots = Arrays.asList(
        new TreeNode(new Integer[]{1, 2, 3, 0, 5, 0, 4}, 0),
        new TreeNode(new Integer[]{1, 0, 3}, 0),
        null
    );

    List<List<Integer>> outputs = Arrays.asList(
        Arrays.asList(new Integer[] {1, 3, 4}),
        Arrays.asList(new Integer[] {1, 3}),
        Arrays.asList(new Integer[] {})
    );

    @Test
    public void rightSideViewTest()
    {
        Problem0199 problem;
        for (int i = 0; i < roots.size(); i++) {
            problem = new Problem0199();
            TreeNode input = roots.get(i);
            List<Integer> output = outputs.get(i);
            List<Integer> result = problem.rightSideView(input);
            assertEquals(result, output);
        }
    }
}
