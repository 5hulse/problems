package com.shulse.leetcode;

import com.shulse.leetcode.util.TreeNode;

import java.util.*;

public class Problem0437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        long current = 0;
        HashMap<Long, Integer> tracker = new HashMap<Long, Integer>();
        tracker.put(0L, 1);

        count = dfs(root, tracker, current, count, (long) targetSum);
        return count;
    }

    int dfs(TreeNode root, HashMap<Long, Integer> tracker, long current, int count, long targetSum) {
        current += (long) root.val;

        long diff = current - targetSum;
        if (tracker.containsKey(diff)) {
            count += tracker.get(diff);
        }

        if (tracker.containsKey(current)) {
            tracker.replace(current, tracker.get(current) + 1);
        } else {
            tracker.put(current, 1);
        }

        if (root.left != null) {
            count = dfs(root.left, tracker, current, count, targetSum);
        }

        if (root.right != null) {
            count = dfs(root.right, tracker, current, count, targetSum);
        }

        if (tracker.containsKey(current)) {
            if (tracker.get(current) == 1) {
                tracker.remove(current);
            } else {
                tracker.replace(current, tracker.get(current) - 1);
            }
        }
        current -= root.val;

        return count;
    }
}
