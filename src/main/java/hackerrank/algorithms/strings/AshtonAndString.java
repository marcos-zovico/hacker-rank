package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/ashton-and-string/problem">Ashton and String</a>
 * Distinct substrings in lexicographic order, concatenated. Return k-th character (1-indexed).
 */
public class AshtonAndString {

    static class Result {

        public static char ashtonString(String s, int k) {
            int n = s.length();
            int[] sa = buildSuffixArray(s);
            int[] lcp = buildLCP(s, sa);
            long pos = 0;
            for (int i = 0; i < n; i++) {
                int suffixLen = n - sa[i];
                int prevLcp = (i > 0) ? lcp[i - 1] : 0;
                for (int len = prevLcp + 1; len <= suffixLen; len++) {
                    long count = pos + len;  // each substring of length len contributes len chars
                    if (k <= count) {
                        return s.charAt(sa[i] + (int) (k - pos - 1));
                    }
                    pos = count;
                }
            }
            return s.charAt(sa[n - 1]);
        }

        private static int[] buildSuffixArray(String s) {
            int n = s.length();
            Integer[] order = new Integer[n];
            int[] equiv = new int[n];
            int[] newEquiv = new int[n];
            for (int i = 0; i < n; i++) {
                order[i] = i;
                equiv[i] = s.charAt(i) - 'a';
            }
            for (int len = 1; len < n; len *= 2) {
                final int fLen = len;
                final int[] e = equiv;
                Arrays.sort(order, (a, b) -> {
                    if (e[a] != e[b]) return Integer.compare(e[a], e[b]);
                    int a2 = a + fLen < n ? e[a + fLen] : -1;
                    int b2 = b + fLen < n ? e[b + fLen] : -1;
                    return Integer.compare(a2, b2);
                });
                newEquiv[order[0]] = 0;
                for (int i = 1; i < n; i++) {
                    int a = order[i - 1], b = order[i];
                    int a2 = a + fLen < n ? equiv[a + fLen] : -1;
                    int b2 = b + fLen < n ? equiv[b + fLen] : -1;
                    newEquiv[b] = (equiv[a] == equiv[b] && a2 == b2) ? newEquiv[a] : i;
                }
                int[] t = equiv;
                equiv = newEquiv;
                newEquiv = t;
            }
            return Arrays.stream(order).mapToInt(i -> i).toArray();
        }

        private static int[] buildLCP(String s, int[] sa) {
            int n = s.length();
            int[] rank = new int[n];
            for (int i = 0; i < n; i++) rank[sa[i]] = i;
            int[] lcp = new int[n];
            int h = 0;
            for (int i = 0; i < n; i++) {
                if (rank[i] == 0) continue;
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) h++;
                lcp[rank[i] - 1] = h;
                if (h > 0) h--;
            }
            return lcp;
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            IntStream.range(0, t).forEach(x -> {
                try {
                    String s = br.readLine().trim();
                    int k = Integer.parseInt(br.readLine().trim());
                    System.out.println(Result.ashtonString(s, k));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            br.close();
        }
    }
}
