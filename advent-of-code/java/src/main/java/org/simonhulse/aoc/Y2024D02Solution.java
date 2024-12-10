//src/main/java/org/simonhulse/aoc/Y2024D02Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Tue 10 Dec 2024 01:32:09 PM EST

package org.simonhulse.aoc;

import java.util.*;

class Level {
    private int[] diffs;
    private int nDiffs;

    public Level(String input) {
        String[] valuesStr = input.split(" ");
        nDiffs = valuesStr.length - 1;
        diffs = new int[nDiffs];
        for (int i = 0; i < nDiffs; i++) {
            diffs[i] = Integer.parseInt(valuesStr[i + 1]) - Integer.parseInt(valuesStr[i]);
        }
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

    private int getProblemIndex(int lo, int hi) {
        int idx = 0;
        while (true) {
            if (!inRange(diffs[idx], lo, hi)) break;
            idx++;
        }
        return idx;
    }

    private int[] getProblemIndices(int lo, int hi) {
        int[] idxs = new int[2];
        int count = 0;
        int i = 0;
        while (count < 2) {
            if (!inRange(diffs[i], lo, hi)) {
                idxs[count] = i;
                count++;
            }
            i++;
        }
        return idxs;
    }

    public boolean isSafePartOne() {
        return ((nBetween(diffs, 1, 3) == nDiffs) || (nBetween(diffs, -3, -1) == nDiffs));
    }

    public boolean isSafePartTwo() {
        int nAscending = nBetween(diffs, 1, 3);
        int nDescending = nBetween(diffs, -3, -1);

        if (nAscending == nDiffs || nDescending == nDiffs) return true;

        if (nAscending == nDiffs - 1) {
            int idx = getProblemIndex(1, 3);
            if (idx == 0) return true;
            if (idx == nDiffs - 1) return true;
            if (inRange(diffs[idx - 1] + diffs[idx], 1, 3)) return true;
            if (idx < nDiffs - 1 && inRange(diffs[idx] + diffs[idx + 1], 1, 3)) return true;
        }

        if (nDescending == nDiffs - 1) {
            int idx = getProblemIndex(-3, -1);
            if (idx == 0 || idx == nDiffs - 1) return true;
            if (inRange(diffs[idx - 1] + diffs[idx], -3, -1)) return true;
            if (idx < nDiffs - 1 && inRange(diffs[idx] + diffs[idx + 1], -3, -1)) return true;
        }

        if (nAscending == nDiffs - 2) {
            int[] idxs = getProblemIndices(1, 3);
            if (idxs[0] + 1 != idxs[1]) return false;
            if (inRange(diffs[idxs[0]] + diffs[idxs[1]], 1, 3)) return true;
        }

        if (nDescending == nDiffs - 2) {
            int[] idxs = getProblemIndices(-3, -1);
            if (idxs[0] + 1 != idxs[1]) return false;
            if (inRange(diffs[idxs[0]] + diffs[idxs[1]], -3, -1)) return true;
        }

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
