package com.shulse.leetcode;

import com.shulse.leetcode.util.ListNode;

class Problem2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        // Jumps forward one every iteration
        ListNode p1 = head;
        // Jumps forward two every iteration
        ListNode p2 = head.next.next;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p1.next = p1.next.next;

        return head;
    }
}
