package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem0872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = new ArrayList<Integer>();
        leaves1 = getLeaves(root1, leaves1);

        ArrayList<Integer> leaves2 = new ArrayList<Integer>();
        leaves2 = getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    ArrayList<Integer> getLeaves(TreeNode root, ArrayList<Integer> leaves) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return leaves;
        }
        if (root.left != null) {
            leaves = getLeaves(root.left, leaves);
        }
        if (root.right != null) {
            leaves = getLeaves(root.right, leaves);
        }
        return leaves;
    }
}
