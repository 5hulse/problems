//src/main/java/org/simonhulse/aoc/Y2024D04Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Wed 11 Dec 2024 11:02:44 AM EST

package org.simonhulse.aoc;

import java.util.*;

class WordSearch {

    private int rows;
    private int cols;
    private char[][] grid;

    char[] forwardMatchXMAS = new char[]{'X', 'M', 'A', 'S'};
    char[] backwardMatchXMAS = new char[]{'S', 'A', 'M', 'X'};
    char[] fourChars = new char[4];

    char[] forwardMatchMAS = new char[]{'M', 'A', 'S'};
    char[] backwardMatchMAS = new char[]{'S', 'A', 'M'};
    char[] threeChars = new char[3];

    public WordSearch(String input) {
        String[] lines = input.split("\n");
        rows = lines.length;
        cols = lines[0].length();
        grid = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String line = lines[row];
            for (int col = 0; col < cols; col++) {
                char c = line.charAt(col);
                grid[row][col] = c;
            }
        }
    }

    private boolean isHitXMAS() {
        return Arrays.equals(fourChars, forwardMatchXMAS) || Arrays.equals(fourChars, backwardMatchXMAS);
    }

    private boolean isHitMAS() {
        return Arrays.equals(threeChars, forwardMatchMAS) || Arrays.equals(threeChars, backwardMatchMAS);
    }

    int rowSearch() {
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) {
                fourChars[0] = grid[row][col];
                fourChars[1] = grid[row][col + 1];
                fourChars[2] = grid[row][col + 2];
                fourChars[3] = grid[row][col + 3];

                if (isHitXMAS()) count += 1;
            }
        }
        return count;
    }

    int colSearch() {
        int count = 0;
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols; col++) {
                fourChars[0] = grid[row][col];
                fourChars[1] = grid[row + 1][col];
                fourChars[2] = grid[row + 2][col];
                fourChars[3] = grid[row + 3][col];

                if (isHitXMAS()) count += 1;
            }
        }
        return count;
    }

    int forwardDiagonalSearch() {
        int count = 0;
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols - 3; col++) {
                fourChars[0] = grid[row + 3][col];
                fourChars[1] = grid[row + 2][col + 1];
                fourChars[2] = grid[row + 1][col + 2];
                fourChars[3] = grid[row][col + 3];

                if (isHitXMAS()) count += 1;
            }
        }
        return count;
    }

    int backwardDiagonalSearch() {
        int count = 0;
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols - 3; col++) {
                fourChars[0] = grid[row][col];
                fourChars[1] = grid[row + 1][col + 1];
                fourChars[2] = grid[row + 2][col + 2];
                fourChars[3] = grid[row + 3][col + 3];

                if (isHitXMAS()) count += 1;
            }
        }
        return count;
    }

    int MASSearch() {
        int count = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                // Check for backward diagonal MAS / SAM
                threeChars[0] = grid[row][col];
                threeChars[1] = grid[row + 1][col + 1];
                threeChars[2] = grid[row + 2][col + 2];

                if (!isHitMAS()) continue;

                // Check for forward diagonal MAS / SAM
                threeChars[0] = grid[row + 2][col];
                threeChars[1] = grid[row + 1][col + 1];
                threeChars[2] = grid[row][col + 2];

                if (isHitMAS()) count += 1;
            }
        }

        return count;
    }
}

public class Y2024D04Solution extends AOCSolution {

    public int partOne(String input) {
        int result = 0;
        WordSearch wordSearch = new WordSearch(input);
        result += wordSearch.rowSearch();
        result += wordSearch.colSearch();
        result += wordSearch.forwardDiagonalSearch();
        result += wordSearch.backwardDiagonalSearch();
        return result;
    };

    public int partTwo(String input) {
        WordSearch wordSearch = new WordSearch(input);
        return wordSearch.MASSearch();
    };

}
