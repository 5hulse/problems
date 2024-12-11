//src/main/java/org/simonhulse/aoc/Y2024D06Solution.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Wed 11 Dec 2024 05:13:30 PM EST

package org.simonhulse.aoc;

import java.util.*;

public class Y2024D06Solution extends AOCSolution {

    public int partOne(String input) {
        Lab lab = new Lab(input);
        while (!lab.isComplete()) {
            lab.takeStep();
        }
        return lab.getNVisited();
    };

    public int partTwo(String input) {
        return 0;
    };

}

class Guard {
    private int row;
    private int col;
    private Orientation orientation;

    public Guard(int row, int col, Orientation orientation) {
        this.row = row;
        this.col = col;
        this.orientation = orientation;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void rotate() {
        orientation = orientation.next();
    }
    public void moveForward() {
        switch (orientation) {
            case NORTH -> row -= 1;
            case EAST -> col += 1;
            case SOUTH -> row += 1;
            case WEST -> col -= 1;
            default -> throw new IllegalStateException("Invalid orientation");
        }
    }

    public void moveBackward() {
        switch (orientation) {
            case NORTH -> row += 1;
            case EAST -> col -= 1;
            case SOUTH -> row -= 1;
            case WEST -> col += 1;
            default -> throw new IllegalStateException("Invalid orientation");
        }
    }
}

class Lab {

    private int rows;
    private int cols;
    private boolean[][] grid;
    private Guard guard;
    private boolean complete = false;
    private Set<Integer> visited;

    public Lab(String input) {
        String[] lines = input.split("\n");
        rows = lines.length;
        cols = lines[0].length();

        grid = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            String line = lines[row];
            for (int col = 0; col < cols; col++) {
                char c = line.charAt(col);
                if (c == '#') grid[row][col] = true;
                else {
                    grid[row][col] = false;
                    switch (c) {
                        case '^' -> guard = new Guard(row, col, Orientation.NORTH);
                        case '>' -> guard = new Guard(row, col, Orientation.EAST);
                        case 'V' -> guard = new Guard(row, col, Orientation.SOUTH);
                        case '<' -> guard = new Guard(row, col, Orientation.WEST);
                        case '.' -> {}
                        default -> throw new IllegalStateException("Invalid char");
                    }
                }

            }
        }

        visited = new HashSet<>();
        addCoordToVisited();
    }

    private void addCoordToVisited() {
        visited.add(getVisitedValue(guard.getRow(), guard.getCol()));
    }

    private int getVisitedValue(int row, int col) {
        return row * cols + col;
    }

    public int getNVisited() {
        return visited.size();
    }

    public boolean isComplete() {
        return complete;
    }

    public void takeStep() {
        while (true) {
            guard.moveForward();

            if (isOutsideGrid()) {
                complete = true;
                break;
            }

            if (hitBarrier()) {
                guard.moveBackward();
                guard.rotate();
            } else {
                addCoordToVisited();
                break;
            }
        }
    }

    private boolean isOutsideGrid() {
        return guard.getRow() < 0 || guard.getRow() >= rows || guard.getCol() < 0 || guard.getCol() >= cols;
    }

    private boolean hitBarrier() {
        return grid[guard.getRow()][guard.getCol()];
    }
}

enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    public Orientation next() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: throw new IllegalStateException("Invalid orientation");
        }
    }
}
