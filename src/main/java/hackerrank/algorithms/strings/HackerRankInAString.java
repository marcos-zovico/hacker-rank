package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class HackerRankInAString {

    class Result {

        private static  final String HR = "hackerrank";

        /*
         * Complete the 'hackerrankInString' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */
        public static String hackerrankInString(String s) {
            int hrIndex = 0;
            for (int i = 0; i < s.length() && hrIndex < HR.length(); i++) {
                if (s.charAt(i) == HR.charAt(hrIndex)) {
                    hrIndex++;
                }
            }
            return hrIndex == HR.length() ? "YES" : "NO";
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();

                    String result = Result.hackerrankInString(s);

                    System.out.println(result);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
        }
    }
}
