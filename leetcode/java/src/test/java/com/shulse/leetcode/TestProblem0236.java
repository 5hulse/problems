package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0236;

public class TestProblem0236 {

    // Using -1 as `null`
    List<TreeNode> roots = Arrays.asList(
        new TreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}, -1),
        new TreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}, -1),
        new TreeNode(new Integer[]{1, 2}, -1)
    );

    List<TreeNode> ps = Arrays.asList(
        roots.get(0).left,
        roots.get(1).left,
        roots.get(2).left
    );

    List<TreeNode> qs = Arrays.asList(
        roots.get(0).right,
        roots.get(1).left.right.right,
        roots.get(2)
    );

    List<TreeNode> outputs = Arrays.asList(
        roots.get(0),
        roots.get(1).left,
        roots.get(2)
    );

    @Test
    public void lowestCommonAncestorTest()
    {
        Problem0236 problem;
        for (int i = 0; i < roots.size(); i++) {
            problem = new Problem0236();
            TreeNode input = roots.get(i);
            TreeNode p = ps.get(i);
            TreeNode q = qs.get(i);
            TreeNode output = outputs.get(i);
            TreeNode result = problem.lowestCommonAncestor(input, p, q);
            assertEquals(result, output);
        }
    }
}
