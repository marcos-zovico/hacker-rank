package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.hackerrank.com/challenges/string-function-calculation/problem">String Function Calculation</a>
 * f(s) = length(s) * count(s) where count = occurrences of s in the string.
 * Find max f(s) over all substrings.
 * Solved in O(n) with Suffix Automaton (SAM).
 */
public class StringFunctionCalculation {

    static class Result {

        public static int maxValue(String t) {
            int n = t.length();
            if (n == 0) return 0;
            SuffixAutomaton sam = new SuffixAutomaton(n);
            for (int i = 0; i < n; i++) {
                sam.extend(t.charAt(i) & 0xFF);
            }
            return (int) sam.maxLengthTimesCount();
        }
    }

    /**
     * Suffix Automaton: at most 2*n-1 states, each state has len and suffix link.
     * For each state, (longest length) * (occurrence count) is a candidate for the answer.
     */
    static class SuffixAutomaton {
        static final int ALPHA = 256;
        final int maxStates;
        final int[] len;
        final int[] link;
        final int[][] next;
        int size;
        int last;
        final long[] count;

        SuffixAutomaton(int n) {
            maxStates = Math.max(2, 2 * n);
            len = new int[maxStates];
            link = new int[maxStates];
            next = new int[maxStates][ALPHA];
            count = new long[maxStates];
            link[0] = -1;
            size = 1;
            last = 0;
        }

        void extend(int c) {
            int cur = size++;
            len[cur] = len[last] + 1;
            count[cur] = 1; // this state was "last" at current position
            int p = last;
            while (p != -1 && next[p][c] == 0) {
                next[p][c] = cur;
                p = link[p];
            }
            if (p == -1) {
                link[cur] = 0;
            } else {
                int q = next[p][c];
                if (len[q] == len[p] + 1) {
                    link[cur] = q;
                } else {
                    int clone = size++;
                    len[clone] = len[p] + 1;
                    link[clone] = link[q];
                    System.arraycopy(next[q], 0, next[clone], 0, ALPHA);
                    link[q] = clone;
                    link[cur] = clone;
                    while (p != -1 && next[p][c] == q) {
                        next[p][c] = clone;
                        p = link[p];
                    }
                }
            }
            last = cur;
        }

        long maxLengthTimesCount() {
            // Sort states by len descending (topological order)
            int[] order = new int[size];
            int[] freq = new int[len[last] + 1];
            for (int i = 0; i < size; i++) freq[len[i]]++;
            for (int i = 1; i < freq.length; i++) freq[i] += freq[i - 1];
            for (int i = size - 1; i >= 0; i--) order[--freq[len[i]]] = i;
            // Propagate counts along suffix links
            for (int i = size - 1; i >= 0; i--) {
                int v = order[i];
                if (link[v] >= 0) count[link[v]] += count[v];
            }
            long max = 0;
            for (int i = 0; i < size; i++) {
                max = Math.max(max, (long) len[i] * count[i]);
            }
            return max;
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String t = br.readLine().trim();
            System.out.println(Result.maxValue(t));
            br.close();
        }
    }
}
