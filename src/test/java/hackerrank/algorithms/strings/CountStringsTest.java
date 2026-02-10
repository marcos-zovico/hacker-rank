package hackerrank.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountStringsTest {

    @Test
    void runCase07First3() throws Exception {
        String in = """
                3
                ((((b|((((((a*)*)|((b|b)a))((a((a|b)*))(a*)))(a|(ab)))|a))*)|(b*))*) 681185765
                (((aa)((((a*)|a)(ab))((ab)|a)))|((((a|a)*)a)|((b((((b|b)a)*)((ba)(b|a))))|a))) 122407503
                ((b|((((a|b)*)|((((b|a)|(((a|a)|(a|b))*))*)*))|((aa)|(((b*)|(b*))*))))*) 476805604""";
        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> CountStrings.Solution.main(new String[]{}));
        assertEquals("257627333\n3\n328967104", actual.strip());
    }

    @Test
    void runCase07() throws Exception {
        InputStream inputStream = CountStringsTest.class
                .getResourceAsStream("/count-strings-case-07-input.txt");
        if (inputStream == null) {
            throw new IOException("Resource file not found: count-strings-case-07-input.txt");
        }
        InputStream expectedStream = CountStringsTest.class
                .getResourceAsStream("/count-strings-case-07-output.txt");
        if (expectedStream == null) {
            throw new IOException("Resource file not found: count-strings-case-07-output.txt");
        }

        byte[] inputBytes = inputStream.readAllBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> CountStrings.Solution.main(new String[]{}));
        String expected = new String(expectedStream.readAllBytes(), StandardCharsets.UTF_8).strip();

        String[] actualLines = actual.strip().split("\n");
        String[] expectedLines = expected.split("\n");
        for (int i = 0; i < Math.max(actualLines.length, expectedLines.length); i++) {
            String exp = i < expectedLines.length ? expectedLines[i] : "<expected missing>";
            String act = i < actualLines.length ? actualLines[i] : "<actual missing>";
            assertEquals(exp, act, "Line " + (i + 1));
        }
    }

    @Test
    void sampleInput() throws Exception {
        String in = """
                3
                ((ab)|(ba)) 2
                ((a|b)*) 5
                ((a*)(b(a*))) 100""";

        System.setIn(new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8)));

        String actual = tapSystemOut(() -> CountStrings.Solution.main(new String[]{}));
        assertEquals("2\n32\n100", actual.strip());
    }

    @Test
    void case07FirstLine() {
        String regex = "((((b|((((((a*)*)|((b|b)a))((a((a|b)*))(a*)))(a|(ab)))|a))*)|(b*))*)";
        long result = CountStrings.Result.countStrings(regex, 681185765);
        assertEquals(257627333, result);
    }

}
