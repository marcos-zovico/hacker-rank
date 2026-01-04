package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class HackerRankinAString {

    class Result {

        private static  final String HR = "hackerrank";

        /*
         * Complete the 'hackerrankInString' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */
        public static String hackerrankInString(String s) {

            // Write your code here
            StringBuilder r = new StringBuilder();
            for (int i = 0; i < HR.length(); i++) {
                for (int j = i +1; j < s.length() ; j++) {
                    if (HR.charAt(i) == s.charAt(j)){
                       r.append(s.charAt(j));
                        break;
                    }
                }
            }

            return HR.contentEquals(r) ? "YES" : "NO";
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
