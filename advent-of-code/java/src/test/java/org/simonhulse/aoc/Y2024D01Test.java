//src/test/java/org/simonhulse/aoc/Y2024D01Test.java
//Simon Hulse
//simonhulse@protonmail.com
//Last Edited: Fri 06 Dec 2024 10:07:57 AM EST

package org.simonhulse.aoc;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Y2024D01Test extends AOCTest {

    public Y2024D01Test() throws IOException {
        super();
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public int getYear() {
        return 2024;
    }

    @Test
    public void testRightPath() {
        System.out.println(String.format("getDataDirectory(): %s", getDataDirectory()));
    }
}
