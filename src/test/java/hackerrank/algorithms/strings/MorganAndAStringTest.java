package hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MorganAndAStringTest {

    @Test
    void runCase01() throws Exception {
        String in = """
                2
                JACK
                DANIEL
                ABACABA
                ABACABA""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> MorganAndAString.Solution.main(new String[]{}));
        assertEquals("DAJACKNIEL\nAABABACABACABA", actual.strip());
    }

    @Test
    void runCase07() throws Exception {
        InputStream inputStream = MorganAndAStringTest.class
                .getResourceAsStream("/morgan-and-a-string-case-07-imput.txt");
        if (inputStream == null) {
            throw new IOException("Resource file not found: morgan-and-a-string-case-07-imput.txt");
        }

        InputStream expectedStream = MorganAndAStringTest.class
                .getResourceAsStream("/morgan-and-a-string-case-07-output.txt");
        if (expectedStream == null) {
            throw new IOException("Resource file not found: morgan-and-a-string-case-07-output.txt");
        }

        byte[] inputBytes = inputStream.readAllBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> MorganAndAString.Solution.main(new String[]{}));

        String expected = new String(expectedStream.readAllBytes(), StandardCharsets.UTF_8).strip();

        assertEquals(expected, actual.strip());
    }
}
