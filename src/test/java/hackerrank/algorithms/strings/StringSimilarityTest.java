package hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSimilarityTest {

    @Test
    void sampleInput() throws Exception {
        String in = """
                2
                ababaa
                aa""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> StringSimilarity.Solution.main(new String[]{}));
        assertEquals("11\n3", actual.strip());
    }
}
