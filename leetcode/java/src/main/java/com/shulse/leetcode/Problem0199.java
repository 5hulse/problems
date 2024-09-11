package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.val);
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);

        TreeNode lastNode = root;

        while (!queue.isEmpty()) {
            root = queue.removeFirst();
            if (root.left != null) {
                queue.addLast(root.left);
            }
            if (root.right != null) {
                queue.addLast(root.right);
            }
            if (root == lastNode && !queue.isEmpty()) {
                lastNode = queue.getLast();
                result.add(lastNode.val);
            }
        }

        return result;
    }
}
