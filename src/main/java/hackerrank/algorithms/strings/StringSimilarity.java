package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/string-similarity/problem">String Similarity</a>
 * For two strings A and B, similarity = length of longest prefix common to both.
 * Sum the similarities of S with each of its suffixes. Uses Z-algorithm.
 */
public class StringSimilarity {

    static class Result {

        public static long stringSimilarity(String s) {
            int n = s.length();
            if (n == 0) return 0;
            int[] z = computeZArray(s);
            long sum = n; // similarity of S with itself = n
            for (int i = 1; i < n; i++) {
                sum += z[i];
            }
            return sum;
        }

        private static int[] computeZArray(String s) {
            int n = s.length();
            int[] z = new int[n];
            int l = 0, r = 0;
            for (int i = 1; i < n; i++) {
                if (i <= r) {
                    z[i] = Math.min(r - i + 1, z[i - l]);
                }
                while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                    z[i]++;
                }
                if (i + z[i] - 1 > r) {
                    l = i;
                    r = i + z[i] - 1;
                }
            }
            return z;
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            IntStream.range(0, t).forEach(i -> {
                try {
                    String s = br.readLine().trim();
                    System.out.println(Result.stringSimilarity(s));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            br.close();
        }
    }
}
