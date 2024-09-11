package com.shulse.leetcode.util;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] vals, int nullIndicator) {
        if (vals.length == 0) {
            return;
        }

        ArrayDeque<TreeNode> nodes = new ArrayDeque<TreeNode>();

        ArrayDeque<Integer> values = new ArrayDeque<Integer>();
        for (int i=0; i<vals.length; i++) {
            values.add(vals[i]);
        }

        TreeNode root = new TreeNode(values.removeFirst());
        nodes.add(root);

        while (values.size() > 0) {
            TreeNode curr = nodes.removeFirst();

            Integer left = values.removeFirst();
            if (left != nullIndicator) {
                curr.left = new TreeNode(left);
                nodes.add(curr.left);
            }

            if (values.size() == 0) {
                break;
            }

            Integer right = values.removeFirst();
            if (right != nullIndicator) {
                curr.right = new TreeNode(right);
                nodes.add(curr.right);
            }
        }

        this.val = root.val;
        this.left = root.left;
        this.right = root.right;
    }

    public static boolean sameTrees(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null ^ q == null) {
            return false;
        }
        else
        {
            if (p.val == q.val && sameTrees(p.left, q.left) && sameTrees(p.right, q.right)) return true;
            else return false;
        }
    }
}
