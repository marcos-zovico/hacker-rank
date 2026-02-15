package hackerrank.algorithms.sorting;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortAdvancedAnalysisTest {

    private static final String IN = """
            2
            5
            1 1 1 2 2
            5
            2 1 3 1 2""";

    private static final String OUT = """
            0
            4""";

    @Test
    void runCode() throws Exception {
        System.setIn(new ByteArrayInputStream(IN.getBytes(StandardCharsets.UTF_8)));
        String actual = tapSystemOut(() -> InsertionSortAdvancedAnalysis.Solution.main(new String[]{}));
        assertEquals(OUT, actual.strip());
    }

    @Test
    void runCase13() throws Exception {
        var loader = InsertionSortAdvancedAnalysisTest.class.getClassLoader();
        byte[] inputBytes = IOUtils.resourceToByteArray("insertion-sort-advanced-analysis-case-13.txt", loader);

        System.setIn(new ByteArrayInputStream(inputBytes));

        String actual = tapSystemOut(() -> InsertionSortAdvancedAnalysis.Solution.main(new String[]{}));

        String expected = """
                2506500154
                2499877170
                2501897228
                2495565902
                2501269518
                2505761608
                2492093746
                2490880601
                2514132325
                2498621203
                2501530571
                2495267862
                2501569028
                2497925255
                2504717487""";

        assertEquals(expected.strip(), actual.strip());
    }
}
