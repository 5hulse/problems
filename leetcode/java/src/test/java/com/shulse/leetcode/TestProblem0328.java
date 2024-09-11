package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.ListNode;
import com.shulse.leetcode.Problem0328;

public class TestProblem0328 {
    Problem0328 problem = new Problem0328();
    List<int[]> inputArrays = Arrays.asList(
        new int[]{1, 2, 3, 4, 5},
        new int[]{2, 1, 3, 5, 6, 4, 7}
    );
    List<int[]> outputArrays = Arrays.asList(
        new int[]{1, 3, 5, 2, 4},
        new int[]{2, 3, 6, 7, 1, 5, 4}
    );

    @Test
    public void oddEvenListTest()
    {
        for (int i = 0; i < inputArrays.size(); i++) {
            ListNode input = new ListNode(inputArrays.get(i));
            ListNode output = new ListNode(outputArrays.get(i));
            ListNode result = problem.oddEvenList(input);
            assert(result.equal(output));
        }
    }
}
