package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.ListNode;
import com.shulse.leetcode.Problem2095;

public class TestProblem2095
{
    Problem2095 problem = new Problem2095();
    List<int[]> inputArrays = Arrays.asList(
        new int[]{1, 3, 4, 7, 1, 2, 6},
        new int[]{1, 2, 3, 4},
        new int[]{2, 1}
    );
    List<int[]> outputArrays = Arrays.asList(
        new int[]{1, 3, 4, 1, 2, 6},
        new int[]{1, 2, 4},
        new int[]{2}
    );

    @Test
    public void deleteMiddleTest()
    {
        for (int i = 0; i < inputArrays.size(); i++) {
            ListNode input = new ListNode(inputArrays.get(i));
            ListNode output = new ListNode(outputArrays.get(i));
            ListNode result = problem.deleteMiddle(input);
            assert(result.equal(output));
        }
    }
}
