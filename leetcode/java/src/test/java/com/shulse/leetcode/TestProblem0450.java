package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.TreeNode;
import com.shulse.leetcode.Problem0450;

public class TestProblem0450 {

    List<TreeNode> roots = Arrays.asList(
        new TreeNode(new Integer[]{5, 3, 6, 2, 4, -1, 7}, -1),
        new TreeNode(new Integer[]{5, 3, 6, 2, 4, -1, 7}, -1)
    );
    List<Integer> keys = Arrays.asList(3, 0);
    List<TreeNode> outputs = Arrays.asList(
        new TreeNode(new Integer[]{5, 4, 6, 2, -1, -1, 7}, -1),
        new TreeNode(new Integer[]{5, 3, 6, 2, 4, -1, 7}, -1)
    );

    @Test
    public void deleteNodeTest()
    {
        Problem0450 problem;
        for (int i = 0; i < roots.size(); i++) {
            problem = new Problem0450();
            TreeNode root = roots.get(i);
            int key = keys.get(i);
            TreeNode output = outputs.get(i);
            TreeNode result = problem.deleteNode(root, key);
            assert(TreeNode.sameTrees(result, output));
        }
    }
}
