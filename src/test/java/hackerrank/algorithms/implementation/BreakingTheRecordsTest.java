package hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BreakingTheRecordsTest {

    @Test
    void testCase1() throws Exception {
        String in = "9\n10 5 20 20 4 5 2 25 1";
        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String actual = tapSystemOut(() -> BreakingTheRecords.Solution.main(new String[]{}));
        assertEquals("2 4", actual.strip());
    }

    @Test
    void testCase2() throws Exception {
        String in = "10\n3 4 21 36 10 28 35 5 24 42";
        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String actual = tapSystemOut(() -> BreakingTheRecords.Solution.main(new String[]{}));
        assertEquals("4 0", actual.strip());
    }

    @Test
    void testCase3() throws Exception {
        String in = "1\n100";
        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String actual = tapSystemOut(() -> BreakingTheRecords.Solution.main(new String[]{}));
        assertEquals("0 0", actual.strip());
    }

    @Test
    void testCase4() throws Exception {
        String in = "5\n12 24 10 24 10";
        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String actual = tapSystemOut(() -> BreakingTheRecords.Solution.main(new String[]{}));
        assertEquals("1 1", actual.strip());
    }
}

