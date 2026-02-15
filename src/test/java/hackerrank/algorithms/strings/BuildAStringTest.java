package hackerrank.algorithms.strings;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildAStringTest {

    @Test
    void sampleInput() throws Exception {
        String in = """
                2
                9 4 5
                aabaacaba
                9 8 9
                bacbacacb""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> BuildAString.Solution.main(new String[]{}));
        assertEquals("26\n42", actual.strip());
    }

    @Test
    void runCase11() throws Exception {
        var loader = BuildAStringTest.class.getClassLoader();
        byte[] inputBytes = IOUtils.resourceToByteArray("build-a-string-case-11-input.txt", loader);
        String expected = IOUtils.resourceToString("build-a-string-case-11-output.txt", StandardCharsets.UTF_8, loader).strip();

        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> BuildAString.Solution.main(new String[]{}));
        assertEquals(expected, actual.strip());
    }
}
