package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/gridland-provinces/problem">Gridland Provinces</a>
 * 2 x n grid, knight visits all cells (Hamiltonian path). Count distinct strings formed.
 */
public class GridlandProvinces {

    private static final int SMALL_N_USE_DFS = 11;

    private static final long MOD1 = 2147483607L;
    private static final long F1 = 107;
    private static final long F2 = 101;
    private static final int MAX_LEN = 1202;
    private static final long[] ARR1 = new long[MAX_LEN];
    private static final long[] ARR2 = new long[MAX_LEN];

    static {
        ARR1[0] = 1;
        ARR2[0] = 1;
        for (int i = 1; i < MAX_LEN; i++) {
            ARR1[i] = (ARR1[i - 1] * F1) % MOD1;
            ARR2[i] = (ARR2[i - 1] * F2) % MOD1;
        }
    }

    static class Result {

        private static Set<Long> result;

        public static int gridlandProvinces(String p1, String p2) {
            int n = p1.length();
            if (n < SMALL_N_USE_DFS) {
                return gridlandProvincesDfs(p1, p2);
            }
            result = new HashSet<>();
            char[] c1 = p1.toCharArray();
            char[] c2 = p2.toCharArray();

            for (int i = 0; i < n; i++) {
                process(c1, c2, i, false);
                process(c2, c1, i, false);
                process(c1, c2, i, true);
                process(c2, c1, i, true);
            }
            reverse(c1);
            reverse(c2);
            for (int i = 0; i < n; i++) {
                process(c1, c2, i, false);
                process(c2, c1, i, false);
                process(c1, c2, i, true);
                process(c2, c1, i, true);
            }
            return result.size();
        }

        private static void process(char[] s1, char[] s2, int k, boolean b) {
            long p1 = 0, p2 = 0, p3 = 0, p4 = 0;
            int n = s1.length;

            for (int i = 0; i < k; i++) {
                p1 = (p1 + s1[i] * ARR1[k - 1 - i]) % MOD1;
                p1 = (p1 + s2[i] * ARR1[k + i]) % MOD1;
                p3 = (p3 + s1[i] * ARR2[k - 1 - i]) % MOD1;
                p3 = (p3 + s2[i] * ARR2[k + i]) % MOD1;
            }
            if (b) {
                p1 = (p1 + s2[k] * ARR1[k * 2]) % MOD1;
                p1 = (p1 + s1[k] * ARR1[k * 2 + 1]) % MOD1;
                p3 = (p3 + s2[k] * ARR2[k * 2]) % MOD1;
                p3 = (p3 + s1[k] * ARR2[k * 2 + 1]) % MOD1;
                char[] t = s1;
                s1 = s2;
                s2 = t;
                k++;
            }
            for (int i = k; i < n; i++) {
                p2 = (p2 + s1[i] * ARR1[n * 2 + k - 1 - i]) % MOD1;
                p2 = (p2 + s2[i] * ARR1[i + k]) % MOD1;
                p4 = (p4 + s1[i] * ARR2[n * 2 + k - 1 - i]) % MOD1;
                p4 = (p4 + s2[i] * ARR2[i + k]) % MOD1;
            }
            result.add(((p1 + p2) % MOD1) * MOD1 + (p3 + p4) % MOD1);

            for (int i = k; i < n - 1; i += 2) {
                p1 = (p1 + s2[i] * ARR1[i * 2]) % MOD1;
                p1 = (p1 + s1[i] * ARR1[i * 2 + 1]) % MOD1;
                p1 = (p1 + s1[i + 1] * ARR1[i * 2 + 2]) % MOD1;
                p1 = (p1 + s2[i + 1] * ARR1[i * 2 + 3]) % MOD1;
                p2 = (p2 + s2[i] * (MOD1 - ARR1[i * 2])) % MOD1;
                p2 = (p2 + s2[i + 1] * (MOD1 - ARR1[i * 2 + 1])) % MOD1;
                p2 = (p2 + s1[i] * (MOD1 - ARR1[n * 2 - 1])) % MOD1;
                p2 = (p2 + s1[i + 1] * (MOD1 - ARR1[n * 2 - 2])) % MOD1;
                p2 = (p2 * F1 * F1) % MOD1;

                p3 = (p3 + s2[i] * ARR2[i * 2]) % MOD1;
                p3 = (p3 + s1[i] * ARR2[i * 2 + 1]) % MOD1;
                p3 = (p3 + s1[i + 1] * ARR2[i * 2 + 2]) % MOD1;
                p3 = (p3 + s2[i + 1] * ARR2[i * 2 + 3]) % MOD1;
                p4 = (p4 + s2[i] * (MOD1 - ARR2[i * 2])) % MOD1;
                p4 = (p4 + s2[i + 1] * (MOD1 - ARR2[i * 2 + 1])) % MOD1;
                p4 = (p4 + s1[i] * (MOD1 - ARR2[n * 2 - 1])) % MOD1;
                p4 = (p4 + s1[i + 1] * (MOD1 - ARR2[n * 2 - 2])) % MOD1;
                p4 = (p4 * F2 * F2) % MOD1;

                result.add(((p1 + p2) % MOD1) * MOD1 + (p3 + p4) % MOD1);
            }
        }

        private static void reverse(char[] a) {
            for (int i = 0, j = a.length - 1; i < j; i++, j--) {
                char t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        private static int gridlandProvincesDfs(String p1, String p2) {
            int n = p1.length();
            Set<String> distinct = new HashSet<>();
            for (int row = 0; row < 2; row++) {
                for (int col = 0; col < n; col++) {
                    boolean[] visited = new boolean[2 * n];
                    StringBuilder path = new StringBuilder();
                    dfs(row, col, p1, p2, n, visited, path, distinct);
                }
            }
            return distinct.size();
        }

        private static void dfs(int row, int col, String p1, String p2, int n,
                               boolean[] visited, StringBuilder path, Set<String> distinct) {
            int idx = row * n + col;
            if (visited[idx]) return;
            char c = (row == 0) ? p1.charAt(col) : p2.charAt(col);
            path.append(c);
            visited[idx] = true;

            int count = 0;
            for (boolean v : visited) if (v) count++;
            if (count == 2 * n) {
                distinct.add(path.toString());
            } else {
                int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] m : moves) {
                    int nr = row + m[0], nc = col + m[1];
                    if (nr >= 0 && nr < 2 && nc >= 0 && nc < n) {
                        dfs(nr, nc, p1, p2, n, visited, path, distinct);
                    }
                }
            }

            path.setLength(path.length() - 1);
            visited[idx] = false;
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int provinces = Integer.parseInt(br.readLine().trim());
            IntStream.range(0, provinces).forEach(p -> {
                try {
                    Integer.parseInt(br.readLine().trim());
                    String s1 = br.readLine().trim();
                    String s2 = br.readLine().trim();
                    System.out.println(Result.gridlandProvinces(s1, s2));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            br.close();
        }
    }
}
