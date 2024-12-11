//src/main/java/org/simonhulse/aoc/Y2024D05Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Wed 11 Dec 2024 01:47:23 PM EST

package org.simonhulse.aoc;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Y2024D05Solution extends AOCSolution {

    private String doubleDigitStr = "(\\d{2})";
    private Pattern doubleDigitPattern = Pattern.compile(doubleDigitStr);
    private Pattern rulePattern = Pattern.compile(
        String.format("^%s\\|%s$", doubleDigitStr, doubleDigitStr), Pattern.MULTILINE
        );

    private HashMap<Integer, Set<Integer>> getRules(String input) {
        HashMap<Integer, Set<Integer>> rules = new HashMap<>();
        Matcher ruleMatcher = rulePattern.matcher(input);

        while (ruleMatcher.find()) {
            int before = Integer.parseInt(ruleMatcher.group(1));
            int after = Integer.parseInt(ruleMatcher.group(2));

            if (!rules.containsKey(before)) {
                rules.put(before, new HashSet<>());
            }
            rules.get(before).add(after);
        }

        return rules;
    }

    private List<List<Integer>> getPages(String input) {
        List<List<Integer>> allPages = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            List<Integer> pages = new ArrayList<>();
            Matcher doubleDigitMatcher = doubleDigitPattern.matcher(line);
            while (doubleDigitMatcher.find()) {
                pages.add(Integer.parseInt(doubleDigitMatcher.group(1)));
            }
            allPages.add(pages);
        }
        return allPages;
    }

    public int partOne(String input) {
        String[] splitInput = input.split("\n\n");
        HashMap<Integer, Set<Integer>> rules = getRules(splitInput[0]);
        List<List<Integer>> allPages = getPages(splitInput[1]);
        int result = 0;
        for (List<Integer> pages : allPages) {
            boolean isValid = true;
            Set<Integer> previous = new HashSet<>();
            for (int page : pages) {
                Set<Integer> invalids = rules.get(page);
                if (invalids != null) {
                    for (int prev: previous) {
                        if (invalids.contains(prev)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                previous.add(page);
            }
            if (isValid) result += pages.get(pages.size() / 2);
        }
        return result;
    };

    public int partTwo(String input) {
        return 0;
    };

}
