package hackerrank.algorithms.strings;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HackerRankinAStringTest {

//    private static final String IN = """
//            14
//            hereiamstackerrank
//            hackerworld
//            hhaacckkekraraannk
//            rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
//            knarrekcah
//            hackerrank
//            hackeronek
//            abcdefghijklmnopqrstuvwxyz
//            rhackerank
//            ahankercka
//            hacakaeararanaka
//            hhhhaaaaackkkkerrrrrrrrank
//            crackerhackerknar
//            hhhackkerbanker""";

    private static final String IN = """
            3
            rhackerank
            crackerhackerknar
            hhhackkerbanker""";

    private static final String OUT = """
            NO
            NO
            NO""";

//    private static final String OUT = """
//            YES
//            NO
//            YES
//            NO
//            NO
//            YES
//            NO
//            NO
//            NO
//            NO
//            YES
//            YES
//            NO
//            NO""";

    @BeforeAll
    static void setup() {
        System.setIn(new ByteArrayInputStream(IN.getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    void runCode() throws Exception {
        String actual = tapSystemOut(() -> HackerRankinAString.Solution.main(new String[]{}));
        assertEquals(OUT, actual.strip());
    }
}