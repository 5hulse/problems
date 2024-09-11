package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem0700 {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();

            if (root.val == val) {
                return root;
            }

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right!= null) {
                queue.add(root.right);
            }
        }

        return null;
    }
}
