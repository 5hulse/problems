package com.shulse.leetcode;

import com.shulse.leetcode.util.ListNode;

import java.util.Arrays;

class Problem2130 {
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        } else if (head.next.next == null) {
            return head.val + head.next.val;
        }

        // Count length
        ListNode p = head;
        int length = 2;
        while (p.next.next != null) {
            length = length + 2;
            p = p.next.next;
        }

        // Put one pointer at end of first half, one at beginning of second half
        int jumps = length / 2 - 1;
        ListNode p1Back = head;
        ListNode p2Front = head.next;
        for (int i = 0; i < jumps; i++) {
            p1Back = p1Back.next;
            p2Front = p2Front.next;
        }

        // Sever first half list
        p1Back.next = null;

        // Reverse second list
        ListNode p2Next = p2Front.next;
        p2Front.next = null;

        while (p2Next.next != null) {
            ListNode nextNode = p2Next.next;
            p2Next.next = p2Front;
            p2Front = p2Next;
            p2Next = nextNode;
        }
        p2Next.next = p2Front;

        // Sum lists beginning at `head` and `p2Next`
        int max = 0;
        while (head != null) {
            max = Math.max(max, head.val + p2Next.val);
            head = head.next;
            p2Next = p2Next.next;
        }

        return max;
    }
}
