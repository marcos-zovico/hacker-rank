package hackerrank.algorithms.strings;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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
        var loader = MorganAndAStringTest.class.getClassLoader();
        byte[] inputBytes = IOUtils.resourceToByteArray("morgan-and-a-string-case-07-imput.txt", loader);
        String expected = IOUtils.resourceToString("morgan-and-a-string-case-07-output.txt", StandardCharsets.UTF_8, loader).strip();

        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> MorganAndAString.Solution.main(new String[]{}));
        assertEquals(expected, actual.strip());
    }
}
