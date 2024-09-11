package com.shulse.leetcode.util;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int[] vals) {
        ListNode head = null;
        for (int i = vals.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(vals[i], head);
            head = newNode;
        }
        this.val = head.val;
        this.next = head.next;
    }

    public boolean equal(ListNode other) {
        if (this == null && other == null) {
            return true;
        } else if (this == null || other == null) {
            return false;
        }

        ListNode this_rest = this.next;
        ListNode other_rest = other.next;

        while (this_rest != null && other_rest != null) {
            if (this_rest.val != other_rest.val) {
                return false;
            }
            this_rest = this_rest.next;
            other_rest = other_rest.next;
        }

        return this_rest == null && this_rest == null;
    }

    public int[] getVals() {
        ArrayList<Integer> valArray = new ArrayList<Integer>();
        valArray.add(this.val);
        ListNode this_rest = this.next;

        while (this_rest != null) {
            valArray.add(this_rest.val);
            this_rest = this_rest.next;
        }

        int[] vals = new int[valArray.size()];
        for (int i=0; i<valArray.size(); i++) {
            vals[i] = valArray.get(i);
        }

        return vals;
    }
}
