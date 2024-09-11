package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem1161 {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        int maxLevel = 0;
        int currLevel = 0;

        // last node in a given level
        TreeNode lastNode = root;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            root = queue.removeFirst();
            currSum += root.val;

            if (root.left != null) {
                queue.addLast(root.left);
            }
            if (root.right != null) {
                queue.addLast(root.right);
            }
            if (root == lastNode) {
                currLevel += 1;
                if (currSum > maxSum) {
                    maxLevel = currLevel;
                    maxSum = currSum;
                }
                currSum = 0;
                if (!queue.isEmpty()) {
                    lastNode = queue.getLast();
                }
            }
        }

        return maxLevel;
    }
}
