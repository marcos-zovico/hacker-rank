# HackerRank in a String!

**Problem:** [HackerRank in a String!](https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem)

## Summary

Determine whether the string contains the word "hackerrank" as a subsequence (characters in order, not necessarily consecutive).

## Approach

One pass: maintain an index into the target "hackerrank". For each character of the string, if it matches the current target character, advance the target index. If we reach the end of "hackerrank", return YES; else NO.

## Solution Details

- **Subsequence:** We must find h, then a, then c, then k, then e, then r, then r, then a, then n, then k in that order. No need to backtrack: greedy left-to-right works.

- **Code:**

```java
private static final String HR = "hackerrank";
int hrIndex = 0;
for (int i = 0; i < s.length() && hrIndex < HR.length(); i++) {
    if (s.charAt(i) == HR.charAt(hrIndex)) {
        hrIndex++;
    }
}
return hrIndex == HR.length() ? "YES" : "NO";
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| hereiamstackerrank | YES |
| hackerworld | NO |
