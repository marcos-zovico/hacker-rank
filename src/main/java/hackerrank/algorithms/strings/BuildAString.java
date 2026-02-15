package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/build-a-string/problem">Build a String</a>
 * Build string: add char costs A, copy substring costs B. Find minimum cost.
 * Uses rolling hash (Rabin-Karp) for O(1) substring lookup instead of O(n) indexOf.
 */
public class BuildAString {

    static class Result {

        public static int buildString(int a, int b, String s) {
            int n = s.length();
            int[] dp = new int[n];
            dp[0] = a;
            int lastL = 0;
            for(int k=1;k<n;++k){
                dp[k] = dp[k-1]+a;
                int L = lastL+1;
                while(L>0){
                    String cur = s.substring(k-L+1, k+1);
                    int idx = s.substring(0, k-L+1).indexOf(cur);
                    if( -1==idx )
                        L--;
                    else{
                        dp[k] = Math.min(dp[k], dp[k-L]+b);
                        break;
                    }
                }
                lastL = L;
            }
            return dp[n-1];
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            IntStream.range(0, t).forEach(x -> {
                try {
                    String[] parts = br.readLine().split(" ");
                    int a = Integer.parseInt(parts[1]);
                    int b = Integer.parseInt(parts[2]);
                    String s = br.readLine().trim();
                    System.out.println(Result.buildString(a, b, s));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            br.close();
        }
    }
}
