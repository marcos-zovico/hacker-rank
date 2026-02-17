package hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HackerRankInAStringTest {

    @Test
    void runCode() throws Exception {
        String in = """
            3
            rhackerank
            crackerhackerknar
            hhhackkerbanker""";

        String out = """
            NO
            NO
            NO""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> HackerRankInAString.Solution.main(new String[]{}));
        assertEquals(out, actual.strip());
    }

    @Test
    void sampleInput0() throws Exception {
        String in = """
                2
                hereiamstackerrank
                hackerworld""";

        String expected = """
                YES
                NO""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> HackerRankInAString.Solution.main(new String[]{}));
        assertEquals(expected.strip(), actual.strip());
    }

    @Test
    void sampleInput1() throws Exception {
        String in = """
                2
                hhaacckkekraraannk
                rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt""";

        String expected = """
                YES
                NO""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> HackerRankInAString.Solution.main(new String[]{}));
        assertEquals(expected.strip(), actual.strip());
    }
}