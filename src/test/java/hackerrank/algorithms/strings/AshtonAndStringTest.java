package hackerrank.algorithms.strings;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AshtonAndStringTest {

    @Test
    void sampleInput() throws Exception {
        String in = """
                1
                dbac
                3""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> AshtonAndString.Solution.main(new String[]{}));
        assertEquals("c", actual.strip());
    }

    @Test
    void runCase03() throws Exception {
        var loader = AshtonAndStringTest.class.getClassLoader();
        byte[] inputBytes = IOUtils.resourceToByteArray("ashton-and-string-case-03-input.txt", loader);
        String expected = IOUtils.resourceToString("ashton-and-string-case-03-output.txt", StandardCharsets.UTF_8, loader).strip();

        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> AshtonAndString.Solution.main(new String[]{}));
        assertEquals(expected, actual.strip());
    }
}
