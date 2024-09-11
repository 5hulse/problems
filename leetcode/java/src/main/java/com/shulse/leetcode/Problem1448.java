package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

public class Problem1448 {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Root is always good as nothing above it
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    int goodNodes(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        if (node.val >= x) {
            // Node is good, increment by 1
            return 1 + goodNodes(node.left, node.val) + goodNodes(node.right, node.val);
        } else {
            // Node is bad, do not add to count
            return goodNodes(node.left, x) + goodNodes(node.right, x);
        }
    }
}
