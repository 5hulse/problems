package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = null;
        TreeNode right = null;

        if (root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        // Found p and q on different branches of the tree => root is the LCA
        if (left != null && right != null) {
            return root;
        }
        // Both p and q exist in the left branch
        else if (left != null) {
            return lowestCommonAncestor(left, p, q);
        }
        // Both p and q exist in the right branch
        else if (right != null) {
            return lowestCommonAncestor(right, p, q);
        }
        // Didn't find p or q => at a leaf
        else {
            return null;
        }
    }
}
