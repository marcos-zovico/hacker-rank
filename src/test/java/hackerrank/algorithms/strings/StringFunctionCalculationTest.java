package hackerrank.algorithms.strings;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringFunctionCalculationTest {

    @Test
    void sample0() throws Exception {
        System.setIn(new ByteArrayInputStream("aaaaaa\n".getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> StringFunctionCalculation.Solution.main(new String[]{}));
        assertEquals("12", actual.strip());
    }

    @Test
    void sample1() throws Exception {
        System.setIn(new ByteArrayInputStream("abcabcddd\n".getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> StringFunctionCalculation.Solution.main(new String[]{}));
        assertEquals("9", actual.strip());
    }

    @Test
    void largeInputNoOOM() {
        // String of 2000 'a': max f(s) at length 1000, count 1001 => 1001*1000 = 1001000
        int n = 2000;
        String t = "a".repeat(n);
        int expected = (n / 2 + 1) * (n / 2); // 1001 * 1000
        assertEquals(expected, StringFunctionCalculation.Result.maxValue(t));
    }

    @Test
    void runCase10() throws Exception {
        var loader = StringFunctionCalculationTest.class.getClassLoader();
        // Input file may be wrapped in multiple lines; problem expects a single line
        String inputContent = IOUtils.resourceToString("string-function-calculation-case-10-input.txt", StandardCharsets.UTF_8, loader);
        String oneLine = inputContent.replace("\n", "").replace("\r", "").trim();
        byte[] inputBytes = (oneLine + "\n").getBytes(StandardCharsets.UTF_8);
        String expected = IOUtils.resourceToString("string-function-calculation-case-10-output.txt", StandardCharsets.UTF_8, loader).strip();

        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> StringFunctionCalculation.Solution.main(new String[]{}));
        assertEquals(expected, actual.strip());
    }
}
