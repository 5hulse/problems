package com.shulse.leetcode;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.shulse.leetcode.Problem0841;


public class TestProblem0841 {
    Problem0841 problem = new Problem0841();

    List<List<List<Integer>>> inputs = Arrays.asList(
        Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            new ArrayList<Integer>()
        ),
        Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 0, 1),
            Arrays.asList(2),
            Arrays.asList(0)
        )
    );

    List<Boolean> outputs = Arrays.asList(true, false);

    @Test
    public void canVisitAllRoomsTest1()
    {
        List<List<Integer>> rooms = inputs.get(0);
        boolean output = outputs.get(0);
        assertEquals(problem.canVisitAllRooms(rooms), output);
    }

    @Test
    public void canVisitAllRoomsTest2()
    {
        List<List<Integer>> rooms = inputs.get(1);
        boolean output = outputs.get(1);
        assertEquals(problem.canVisitAllRooms(rooms), output);
    }
}
