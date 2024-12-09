//src/test/java/org/simonhulse/aoc/AOCTest.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Mon 09 Dec 2024 04:53:03 PM EST

package org.simonhulse.aoc;

import java.lang.reflect.InvocationTargetException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.moandjiezana.toml.Toml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeFalse;


class TestData {
    private String input;
    private int output;

    public TestData(String input, int output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }
public int getOutput() {
        return output;
    }
}

public abstract class AOCTest {

    private static final String dataDirectoryTemplate = "../inputs/%d-%02d";

    public abstract int getDay();

    public abstract int getYear();

    TestData part1TestData;
    TestData part2TestData;
    String mainInput;

    public AOCTest() throws IOException {
        part1TestData = getTestData(1);
        part2TestData = null;
        try {
            part2TestData = getTestData(2);
        } catch (IOException exc) { }
        mainInput = getMainInput();
    }

    protected String getDataDirectory() {
        return String.format(dataDirectoryTemplate, getYear(), getDay());
    }

    private String getMainInput() throws IOException {
        Path path = Path.of(getDataDirectory(), "main.txt");
        return Files.readString(path);
    }

    private TestData getTestData(int part) throws IOException {
        Path path = Path.of(getDataDirectory(), String.format("part%d-example.toml", part));
        String fileContent = Files.readString(path);
        Toml toml = new Toml().read(fileContent);
        TestData testData = toml.to(TestData.class);
        return testData;
    }

    private AOCSolution getSolution() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String className = String.format("org.simonhulse.aoc.Y%dD%02dSolution", getYear(), getDay());
        Class<?> clazz = Class.forName(className);
        Object obj = clazz.getDeclaredConstructor().newInstance();
        AOCSolution solution = (AOCSolution) obj;
        return solution;
    }

    @Test
    public void testPartOne() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        AOCSolution solution = getSolution();
        String input = part1TestData.getInput();
        int expected = part1TestData.getOutput();
        int result = solution.partOne(input);
        assertEquals(result, expected);

        int mainResult = solution.partOne(mainInput);
        System.out.println(String.format("Year %d, Day %d, Part 1: %d", getYear(), getDay(), mainResult));
    }

    @Test
    public void testPartTwo() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        assumeFalse(part2TestData == null);

        AOCSolution solution = getSolution();
        String input = part2TestData.getInput();
        int expected = part2TestData.getOutput();
        int result = solution.partTwo(input);
        assertEquals(result, expected);

        int mainResult = solution.partTwo(mainInput);
        System.out.println(String.format("Year %d, Day %d, Part 2: %d", getYear(), getDay(), mainResult));
    }
}
