package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // root.val matches key
            if (root.left == null) {
                // Node is either childless or has one child (right)
                return root.right;
            } else if (root.right == null) {
                // Node has one child (left)
                return root.left;
            } else {
                // Node has two children
                // Find the leftmost node to the right child,
                // make the left of this node the left child,
                // and return the right child.
                TreeNode lastLeft = root.right;
                while (lastLeft.left != null) {
                    lastLeft = lastLeft.left;
                }
                lastLeft.left = root.left;
                return root.right;
            }
        }
        return root;
    }

    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            System.out.println(String.format("root.val: %s", root.val));
            if (root.left != null) {
                System.out.println(String.format("left of root: %s", root.left.val));
                queue.add(root.left);
            }
            if (root.right!= null) {
                System.out.println(String.format("right of root: %s", root.right.val));
                queue.add(root.right);
            }
        }
    }
}
