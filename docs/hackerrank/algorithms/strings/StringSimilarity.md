# String Similarity

**Problem:** [String Similarity](https://www.hackerrank.com/challenges/string-similarity/problem)

## Summary

For each suffix of string S, define similarity as the length of the longest common prefix of S and that suffix. Return the sum of all these similarities.

## Approach

Use the Z-algorithm: compute the Z-array where Z[i] is the length of the longest substring starting at i that matches a prefix of S. The similarity of S with the suffix starting at i is Z[i]. Sum Z[0]=n (S with itself) plus Z[1] through Z[n−1].

## Solution Details

- **Z-array:** Z[i] = length of longest prefix match between S and S[i..]. So similarity between S and suffix starting at i is Z[i]. We compute Z in O(n) with the standard Z-algorithm (maintain [l, r] window and use previously computed Z values when i ≤ r).

- **Result.stringSimilarity:**

```java
public static long stringSimilarity(String s) {
    int n = s.length();
    if (n == 0) return 0;
    int[] z = computeZArray(s);
    long sum = n;
    for (int i = 1; i < n; i++) {
        sum += z[i];
    }
    return sum;
}
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n) for the Z-array

## Example

| Input | Output |
|-------|--------|
| ababaa | 11 |
