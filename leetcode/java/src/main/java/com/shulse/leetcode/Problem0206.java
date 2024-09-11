package com.shulse.leetcode;

import com.shulse.leetcode.util.ListNode;

import java.util.Arrays;

class Problem0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        p1.next = null;
        while (p2.next != null) {
            ListNode nextNode = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = nextNode;
        }

        p2.next = p1;

        return p2;
    }
}
