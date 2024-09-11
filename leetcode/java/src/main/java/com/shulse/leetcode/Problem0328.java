package com.shulse.leetcode;

import com.shulse.leetcode.util.ListNode;

import java.util.Arrays;
class Problem0328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode pOdd = head;
        ListNode pEven = head.next;
        ListNode pFirstEven = head.next;

        while (pEven.next != null && pEven.next.next != null) {
            pOdd.next = pOdd.next.next;
            pEven.next = pEven.next.next;
            pOdd = pOdd.next;
            pEven = pEven.next;
        }

        if (pOdd.next.next != null) {
            pOdd.next = pOdd.next.next;
            pOdd = pOdd.next;
        }

        pEven.next = null;
        pOdd.next = pFirstEven;

        return head;
    }
}
