//src/main/java/org/simonhulse/aoc/Y2024D01Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Mon 09 Dec 2024 05:14:42 PM EST

package org.simonhulse.aoc;

import static java.lang.Math.abs;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Y2024D01Solution extends AOCSolution {

    private final Pattern lineRegex = Pattern.compile("(\\d+)\\s+(\\d+)");

    private int[][] getLists(String input) {
        String[] lines = input.split("\n");
        int nLines = lines.length;
        int[][] lists = new int[2][nLines];

        for (int i = 0; i < nLines; i++) {
            String line = lines[i];
            Matcher matcher = lineRegex.matcher(line);
            // Know this will be `true`
            matcher.matches();
            lists[0][i] = Integer.parseInt(matcher.group(1));
            lists[1][i] = Integer.parseInt(matcher.group(2));
        }
        return lists;
    }

    public int partOne(String input) {
        int[][] lists = getLists(input);
        int[] list1 = lists[0];
        int[] list2 = lists[1];

        Arrays.sort(list1);
        Arrays.sort(list2);

        int result = 0;
        for (int i = 0; i < list1.length; i++) {
            result += abs(list1[i] - list2[i]);
        }

        return result;
    };

    public int partTwo(String input) {
        int[][] lists = getLists(input);
        int[] list1 = lists[0];
        int[] list2 = lists[1];

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            int x = list2[i];
            if (counter.containsKey(x)) {
                counter.put(x, counter.get(x) + 1);
            } else {
                counter.put(x, 1);
            }
        }

        int result = 0;
        for (int i = 0; i < list1.length; i++) {
            int x = list1[i];
            if (counter.containsKey(x)) {
                result += x * counter.get(x);
            }
        }

        return result;
    };

}
