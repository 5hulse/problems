//src/test/java/org/simonhulse/aoc/AOCTest.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Fri 06 Dec 2024 12:05:38 PM EST

package org.simonhulse.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.moandjiezana.toml.Toml;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


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

    @Test
    public void testPart1() {
        assertTrue(true);
    }
}
