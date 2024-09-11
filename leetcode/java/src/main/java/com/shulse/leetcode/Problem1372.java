package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

public class Problem1372 {
    int result = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return result;
    }

    void dfs(TreeNode root, int leftLength, int rightLength) {
        this.result = Math.max(this.result, Math.max(leftLength, rightLength));

        if (root.left != null) {
            dfs(root.left, rightLength + 1, 0);
        }
        if (root.right != null) {
            dfs(root.right, 0, leftLength + 1);
        }

    }
}
