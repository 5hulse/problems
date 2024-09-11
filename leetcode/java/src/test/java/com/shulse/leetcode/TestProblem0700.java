package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0700;

public class TestProblem0700 {

    List<TreeNode> roots = Arrays.asList(
        new TreeNode(new Integer[]{4, 2, 7, 1, 3}, 0),
        new TreeNode(new Integer[]{4, 2, 7, 1, 3}, 0)
    );

    List<Integer> vals = Arrays.asList(2, 5);

    List<TreeNode> outputs = Arrays.asList(
        roots.get(0).left,
        null
    );

    @Test
    public void searchBSTTest()
    {
        Problem0700 problem;
        for (int i = 0; i < roots.size(); i++) {
            problem = new Problem0700();
            TreeNode root = roots.get(i);
            int val = vals.get(i);
            TreeNode output = outputs.get(i);
            TreeNode result = problem.searchBST(root, val);
            assertEquals(result, output);
        }
    }
}
