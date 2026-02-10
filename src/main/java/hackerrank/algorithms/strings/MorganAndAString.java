package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/morgan-and-a-string/problem">Morgan and a String</a>
 * Lexicographically minimal string by merging two stacks (take from top only).
 */
public class MorganAndAString {

    static class Result {

        public static String morganAndString(String a, String b) {
            int n = a.length();
            int m = b.length();
            char[] ac = a.toCharArray();
            char[] bc = b.toCharArray();
            char[] out = new char[n + m];
            int i = 0, j = 0;
            int pos = 0;

            while (i < n || j < m) {
                if (i >= n) {
                    out[pos++] = bc[j++];
                } else if (j >= m) {
                    out[pos++] = ac[i++];
                } else if (ac[i] < bc[j]) {
                    out[pos++] = ac[i++];
                } else if (ac[i] > bc[j]) {
                    out[pos++] = bc[j++];
                } else {
                    int take = compareAndBatch(ac, i, n, bc, j, m, out, pos);
                    if (take > 0) {
                        for (int t = 0; t < take; t++) {
                            out[pos++] = ac[i++];
                        }
                    } else {
                        for (int t = 0; t < -take; t++) {
                            out[pos++] = bc[j++];
                        }
                    }
                }
            }
            return new String(out);
        }

        /**
         * Compare ac[i..] with bc[j..]. Returns number of chars to take from a (positive)
         * or from b (negative). Batches the run to avoid O(n^2) when strings have long equal prefixes.
         */
        private static int compareAndBatch(char[] ac, int i, int n, char[] bc, int j, int m,
                char[] out, int outPos) {
            int lenA = n - i;
            int lenB = m - j;
            int k = 0;
            int limit = Math.min(lenA, lenB);
            while (k < limit && ac[i + k] == bc[j + k]) {
                k++;
            }
            int takeFromA;
            if (k < limit) {
                takeFromA = ac[i + k] <= bc[j + k] ? 1 : -1;
            } else {
                takeFromA = lenA >= lenB ? 1 : -1; // prefix: prefer longer
            }
            // When identical (lenA==lenB), take 1 at a time to interleave; else batch k
            int batch = (lenA == lenB) ? 1 : k;
            if (batch == 0) batch = 1;
            if (takeFromA > 0) {
                return batch;
            } else {
                return -batch;
            }
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            IntStream.range(0, t).forEach(x -> {
                try {
                    String a = br.readLine().trim();
                    String b = br.readLine().trim();
                    System.out.println(Result.morganAndString(a, b));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            br.close();
        }
    }
}
