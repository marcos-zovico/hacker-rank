package hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridlandProvincesTest {

    @Test
    void sampleInput() throws Exception {
        String in = """
                3
                1
                a
                a
                3
                dab
                abd
                5
                ababa
                babab""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> GridlandProvinces.Solution.main(new String[]{}));
        assertEquals("1\n8\n2", actual.strip());
    }

    @Test
    void case02() throws Exception {
        Path input = Path.of("src/test/resources/gridland-provinces-case-02-input.txt");
        Path output = Path.of("src/test/resources/gridland-provinces-case-02-output.txt");
        if (!Files.exists(input) || !Files.exists(output)) return;
        String in = Files.readString(input);
        String expected = Files.readString(output).strip();
        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> GridlandProvinces.Solution.main(new String[]{}));
        assertEquals(expected, actual.strip());
    }
}
