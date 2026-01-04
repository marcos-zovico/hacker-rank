package hackerrank.algorithms.implementation;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberLineJumpsTest {

    @Test
    void testCase1() throws Exception {
        String in = "0 3 4 2";
        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> NumberLineJumps.Solution.main(new String[]{}));
        assertEquals("YES", actual.strip());
    }

    @Test
    void testCase2() throws Exception {
        String in = "0 2 5 3";
        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> NumberLineJumps.Solution.main(new String[]{}));
        assertEquals("NO", actual.strip());
    }

    @Test
    void testCase3() throws Exception {
        String in = "1817 9931 8417 190";
        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> NumberLineJumps.Solution.main(new String[]{}));
        assertEquals("NO", actual.strip());
    }

    @Test
    void testCase4() throws Exception {
        String in = "43 2 70 2";
        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> NumberLineJumps.Solution.main(new String[]{}));
        assertEquals("NO", actual.strip());
    }
}