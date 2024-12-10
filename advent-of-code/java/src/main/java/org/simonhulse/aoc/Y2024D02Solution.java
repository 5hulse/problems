//src/main/java/org/simonhulse/aoc/Y2024D02Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Tue 10 Dec 2024 11:47:03 AM EST

package org.simonhulse.aoc;

import java.util.*;

class Level {
    private int[] diffs;
    private int[] values;
    private int nValues;

    public Level(String input) {
        String[] valuesStr = input.split(" ");
        nValues = valuesStr.length;
        values = new int[nValues];
        diffs = new int[nValues - 1];

        for (int i = 0; i < nValues - 1; i++) {
            diffs[i] = Integer.parseInt(valuesStr[i + 1]) - Integer.parseInt(valuesStr[i]);
            values[i] = Integer.parseInt(valuesStr[i]);
        }
        values[nValues - 1] = Integer.parseInt(valuesStr[nValues - 1]);
    }

    private boolean inRange(int x, int lo, int hi) {
        return x >= lo && x <= hi;
    }

    private int nBetween(int[] values, int lo, int hi) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (inRange(values[i], lo, hi)) count += 1;
        }
        return count;
    }

    private int getProblemIdx(int lo, int hi) {
        int problemIdx = 0;
        while (true) {
            if (!inRange(diffs[problemIdx], lo, hi)) {
                break;
            }
            problemIdx++;
        }
        return problemIdx;
    }

    private boolean safeAfterRemoval(boolean nValid, int lo, int hi) {
        int idx = getProblemIdx(lo, hi);
        if ((idx > 0) && inRange(diffs[idx - 1] + diffs[idx], lo, hi)) return true;
        if ((idx < nValues - 2) && (inRange(diffs[idx] + diffs[idx + 1], lo, hi))) return true;
        return false;
    }

    public boolean isSafePartOne() {
        return ((nBetween(diffs, 1, 3) == nValues - 1) || (nBetween(diffs, -3, -1) == nValues - 1));
    }

    public boolean isSafePartTwo() {
        int nAscending = nBetween(diffs, 1, 3);
        int nDescending = nBetween(diffs, -3, -1);

        if (nAscending == nValues - 1 || nDescending == nValues - 1) return true;
        if (nAscending == nValues - 2 || nAscending == nValues - 3) {
            if (safeAfterRemoval(nAscending, 1, 3)) {
                return true;
            }
        }
        if (nDescending == nValues - 2 || nDescending == nValues - 3) return safeAfterRemoval(-3, -1);
        return false;
    }
}

public class Y2024D02Solution extends AOCSolution {

    private Level[] getLevels(String input) {
        String[] lines = input.split("\n");
        int nLines = lines.length;
        Level[] levels = new Level[nLines];

        for (int i = 0; i < nLines; i++) {
            levels[i] = new Level(lines[i]);
        }

        return levels;
    }

    public int partOne(String input) {
        int result = 0;
        Level[] levels = getLevels(input);
        for (Level level : levels) {
            if (level.isSafePartOne()) {
                result += 1;
            }
        }

        return result;
    }

    public int partTwo(String input) {
        int result = 0;
        Level[] levels = getLevels(input);
        for (Level level : levels) {
            if (level.isSafePartTwo()) {
                result += 1;
            }
        }

        return result;
    }

}
