//src/main/java/org/simonhulse/aoc/Y2024D03Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Tue 10 Dec 2024 02:41:24 PM EST

package org.simonhulse.aoc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Slice {

    private int start;
    private int end = -1;

    public Slice(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public String toString() {
        return String.format("Slice(%d, %d)", start, end);
    }
}

public class Y2024D03Solution extends AOCSolution {

    Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)", Pattern.MULTILINE);
    Pattern doPattern = Pattern.compile("do\\(\\)", Pattern.MULTILINE);
    Pattern dontPattern = Pattern.compile("don't\\(\\)", Pattern.MULTILINE);

    private List<Slice> getValidSections(String input) {
        Matcher doMatcher = doPattern.matcher(input);
        List<Integer> doIndices = new ArrayList<>();
        while (doMatcher.find()) {
            doIndices.add(doMatcher.end());
        }
        Matcher dontMatcher = dontPattern.matcher(input);
        List<Integer> dontIndices = new ArrayList<>();
        while (dontMatcher.find()) {
            dontIndices.add(dontMatcher.end());
        }

        List<Slice> validSections = new ArrayList<>();
        int start = 0;
        int end = -1;
        doIndices.add(0, start);
        Slice currSlice;
        while (doIndices.size() > 0 || dontIndices.size() > 0) {
            // Find first do index greater than previous slice end
            while (doIndices.size() > 0 && doIndices.get(0) < end) {
                doIndices.remove(0);
            }

            if (doIndices.size() > 0) {
                start = doIndices.remove(0);
                currSlice = new Slice(start);
            } else break;

            // Find first dont index greater than slice start
            while (dontIndices.size() > 0 && dontIndices.get(0) < currSlice.getStart()) {
                dontIndices.remove(0);
            }

            if (dontIndices.size() > 0) {
                end = dontIndices.remove(0);
            } else {
                end = input.length();
            };
            currSlice.setEnd(end);
            validSections.add(currSlice);
        }

        return validSections;
    }

    public int partOne(String input) {
        Matcher matcher = mulPattern.matcher(input);
        int result = 0;
        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            result += x * y;
        }
        return result;
    };

    public int partTwo(String input) {
        List<Slice> validSections = getValidSections(input);
        int result = 0;
        for (Slice slice : validSections) {
            String subString = input.substring(slice.getStart(), slice.getEnd());
            result += partOne(subString);
        }
        return result;
    };

}
