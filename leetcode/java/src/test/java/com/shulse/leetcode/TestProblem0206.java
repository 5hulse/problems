package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.ListNode;
import com.shulse.leetcode.Problem0206;

public class TestProblem0206 {
    Problem0206 problem = new Problem0206();
    List<int[]> inputArrays = Arrays.asList(
        new int[]{1, 2, 3, 4, 5},
        new int[]{1, 2}
    );
    List<int[]> outputArrays = Arrays.asList(
        new int[]{5, 4, 3, 2, 1},
        new int[]{2, 1}
    );

    @Test
    public void reverseListTest()
    {
        for (int i = 0; i < inputArrays.size(); i++) {
            ListNode input = new ListNode(inputArrays.get(i));
            ListNode output = new ListNode(outputArrays.get(i));
            ListNode result = problem.reverseList(input);
            assert(result.equal(output));
        }
    }
}
