package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

public class Problem0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
