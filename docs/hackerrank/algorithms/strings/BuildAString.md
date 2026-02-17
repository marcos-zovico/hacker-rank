# Build a String

**Problem:** [Build a String](https://www.hackerrank.com/challenges/build-a-string/problem)

## Summary

Build a string from scratch: add one character costs A, copy any existing substring and append it costs B. Find the minimum cost to build the target string.

## Approach

Dynamic programming: dp[k] = minimum cost to build the prefix of length k. Either append one character (dp[k-1] + A) or find the longest substring ending at k that appears earlier and copy it (dp[k-L] + B). Take the minimum.

## Solution Details

- **State:** dp[k] = min cost to build s[0..k]. dp[0] = 0 (or we start with first char: dp[1] = A).

- **Transition:** For each k, try: (1) dp[k] = dp[k-1] + A. (2) For length L, if s[k-L+1..k] occurs in s[0..k-L], then dp[k] = min(dp[k], dp[k-L] + B). Search for the maximum L such that the substring appears (greedy: longer copy is better when B < L*A).

- **Result.buildString:**

```java
public static int buildString(int a, int b, String s) {
    int n = s.length();
    int[] dp = new int[n];
    dp[0] = a;
    int lastL = 0;
    for (int k = 1; k < n; ++k) {
        dp[k] = dp[k - 1] + a;
        int L = lastL + 1;
        while (L > 0) {
            String cur = s.substring(k - L + 1, k + 1);
            int idx = s.substring(0, k - L + 1).indexOf(cur);
            if (idx == -1)
                L--;
            else {
                dp[k] = Math.min(dp[k], dp[k - L] + b);
                break;
            }
        }
        lastL = L;
    }
    return dp[n - 1];
}
```

- **Optimization:** The solution can use rolling hash (Rabin-Karp) so that substring search is O(1) amortized instead of O(n) indexOf.

## Time and Space Complexity

- **Time:** O(n²) with indexOf; O(n) with rolling hash
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| a=4, b=5, s=aabaacaba | 26 |
