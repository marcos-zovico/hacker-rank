# Ashton and String

**Problem:** [Ashton and String](https://www.hackerrank.com/challenges/ashton-and-string/problem)

## Summary

Take all distinct substrings of the string, sort them lexicographically, concatenate them, and return the k-th character (1-indexed).

## Approach

Build the suffix array and LCP array. Iterate over suffixes in sorted order; for each suffix, consider its distinct prefixes (substrings) that are not covered by the previous suffix (using LCP). Each substring of length L contributes L characters to the concatenation. Find which suffix and which character in that substring corresponds to position k.

## Solution Details

- **Suffix array:** Sort all suffixes lexicographically (e.g. doubling with radix sort or comparison). LCP[i] = longest common prefix of suffix at sa[i] and sa[i+1].

- **Enumerating distinct substrings:** For suffix starting at sa[i] with length suffixLen, the distinct new substrings are those with length from (prevLcp+1) to suffixLen. For each length len, the substring adds len characters. So we advance pos by len until pos + len >= k; then the k-th character is at offset (k - pos - 1) within that substring.

- **Result.ashtonString:**

```java
public static char ashtonString(String s, int k) {
    int n = s.length();
    int[] sa = buildSuffixArray(s);
    int[] lcp = buildLCP(s, sa);
    long pos = 0;
    for (int i = 0; i < n; i++) {
        int suffixLen = n - sa[i];
        int prevLcp = (i > 0) ? lcp[i - 1] : 0;
        for (int len = prevLcp + 1; len <= suffixLen; len++) {
            long count = pos + len;
            if (k <= count) {
                return s.charAt(sa[i] + (int) (k - pos - 1));
            }
            pos = count;
        }
    }
    return s.charAt(sa[n - 1]);
}
```

## Time and Space Complexity

- **Time:** O(n log n) for suffix array + O(n) for scan
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| dbac, k=3 | c |
