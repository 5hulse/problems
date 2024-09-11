package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.util.ListNode;
import com.shulse.leetcode.Problem2130;

public class TestProblem2130 {
    Problem2130 problem = new Problem2130();
    List<int[]> inputArrays = Arrays.asList(
        new int[]{5, 4, 2, 1},
        new int[]{4, 2, 2, 3},
        new int[]{7, 57, 13, 31, 17, 65, 32, 3, 97, 22, 7, 20, 69, 35, 69, 75, 13, 33, 50, 80, 64, 71, 15, 28, 2, 27, 39, 48, 13, 22, 84, 5, 51, 46, 26, 78, 56, 63}
    );
    List<Integer> outputArrays = Arrays.asList(6, 7, 130);

    @Test
    public void pairSumTest()
    {
        for (int i = 0; i < inputArrays.size(); i++) {
            ListNode input = new ListNode(inputArrays.get(i));
            int output = outputArrays.get(i);
            int result = problem.pairSum(input);
            assertEquals(result, output);
        }
    }
}
