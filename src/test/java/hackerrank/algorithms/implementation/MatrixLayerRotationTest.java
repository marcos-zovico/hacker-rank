package hackerrank.algorithms.implementation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixLayerRotationTest {

    @Test
    void testCase1() throws Exception {
        String in = """
                4 4 2
                1 2 3 4
                5 6 7 8
                9 10 11 12
                13 14 15 16""";

        String expected = """
                3 4 8 12
                2 11 10 16
                1 7 6 15
                5 9 13 14""";

        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String result = tapSystemOut(() -> MatrixLayerRotation.Solution.main(new String[]{}));
        assertEquals(expected.strip(), result.strip());
    }

    @Test
    void testCase2() throws Exception {
        String in = """
                5 4 7
                1 2 3 4
                7 8 9 10
                13 14 15 16
                19 20 21 22
                25 26 27 28""";

        String expected = """
                28 27 26 25
                22 9 15 19
                16 8 21 13
                10 14 20 7
                4 3 2 1""";

        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String result = tapSystemOut(() -> MatrixLayerRotation.Solution.main(new String[]{}));
        assertEquals(expected.strip(), result.strip());
    }

    @Test
    void testCase3() throws Exception {
        String in = """
                2 2 3
                1 1
                1 1""";

        String expected = """
                1 1
                1 1""";

        System.setIn(new ByteArrayInputStream(in.getBytes(UTF_8)));

        String result = tapSystemOut(() -> MatrixLayerRotation.Solution.main(new String[]{}));
        assertEquals(expected.strip(), result.strip());
    }

}

